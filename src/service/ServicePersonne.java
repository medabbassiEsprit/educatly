/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import entities.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDb;

/**
 *
 * @author Mayssa
 */
public class ServicePersonne implements IService<Personne>{
    Connection cnx =MyDb.getInstance().getCnx();
    
    //singleton
    public static ServicePersonne Instance=null;
   
   public static ServicePersonne getInstance(){
       if(Instance == null)
           Instance = new ServicePersonne();
        return Instance;
      
   }
   public Personne auth(String username,String password) {
       Personne p = new Personne();
     
       
      String a= new String() ;
      
    try
    {   String sql = "SELECT * FROM `users` Where `username` = '"+username+"' AND `password` = '"+password+"'";
        Statement stm =cnx.createStatement();
        ResultSet rs=  stm.executeQuery(sql);
        System.out.println("======>"+sql);
        while(rs.next())
        {
           p.setUsername( rs.getString("username"));
           p.setPassword(rs.getString("password")); 
           p.setRole(rs.getString("role"));
           p.setNom(rs.getString("nom"));
           p.setPrenom(rs.getString("prenom"));
           p.setPhoneNumber(rs.getString("phoneNumber"));
           p.setEmail(rs.getString("email"));
           
           
            
//            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("ADMIN"))
//            p.setRole("ADMIN");
//            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("FORMATEUR"))
//            p.setRole("FORMATEUR");
//            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("APPRENANT"))
//            p.setRole("APPRENANT");
           
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return p;
   }
   
   
   @Override
   public void ajouter(Personne t) {
       try {
            String qry ="INSERT INTO `users`( `nom`, `prenom`,`username`,`email`,`password`,`role`,`phoneNumber`,`dateN`) "
                    + "VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getUsername()+"','"+t.getEmail()+"','"+t.getPassword()+"','"+t.getRole()+"','"+t.getPhoneNumber()+"','"+t.getDateN()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
      
  }
    public void ajouterF(Personne t1) {
       try {
            String qry ="INSERT INTO `users`(`nom`, `prenom`,`username`,`email`,`password`,`role`,`phoneNumber`,`dateN`,`file_formateur`) "
                    + "VALUES ('"+t1.getNom()+"','"+t1.getPrenom()+"','"+t1.getUsername()+"','"+t1.getEmail()+"','"+t1.getPassword()+"','"+t1.getRole()+"','"+t1.getPhoneNumber()+"','"+t1.getDateN()+"','"+t1.getFile_formateur()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
           
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
      
  }
      public void update(String nom,String prenom,String phoneNumber , String email , String username) {
         Personne p = new Personne();
       try{
            String requet= "UPDATE `users` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`email`='"+email+"',`phoneNumber`='"+phoneNumber+"' WHERE `username`='"+username+"'";
                    
                  Statement stm =cnx.createStatement();
                  stm.executeUpdate(requet);
                  
                  
                  
                  
       
       } catch (SQLException ex) {
           ex.printStackTrace();
      }
       
    }

    @Override
   public List<Personne> afficher() {
     List<Personne> personnes = new ArrayList();
        
      try {
           String qry ="select * from users ";
          
          Statement stm =cnx.createStatement();
          ResultSet rs=  stm.executeQuery(qry);
          while(rs.next()){
             Personne p = new Personne();
             p.setId(rs.getInt("id"));
             p.setNom(rs.getString("nom"));
             p.setPrenom(rs.getString("prenom"));
             p.setUsername(rs.getString("username"));
             p.setEmail(rs.getString("email"));
             p.setPassword(rs.getString("password"));
             p.setPhoneNumber(rs.getString("phoneNumber"));
             p.setRole(rs.getString("Role"));
             p.setDateN(rs.getDate("DateN"));
             p.setFile_formateur(rs.getString("file_formateur"));
        
         personnes.add(p);
          }
           
           
         
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
       }
        return personnes;
   }

   @Override
   public void modifier(Personne t) {
   }
   
   @Override
   public void supprimer(Personne t) {
   }
   
   
   
   
}
