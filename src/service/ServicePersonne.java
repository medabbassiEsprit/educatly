/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Personne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import utils.MyDb;

/**
 *
 * @author Mayssa
 */
public class ServicePersonne implements IService<Personne>{
    Connection cnx =MyDb.getInstance().getCnx();
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
      public void update(Personne t1){
       try{
        String qry= "UPDATE `USERS` " +
                    "SET nom = '" + t1.getNom() + "' prenom " +t1.getPrenom()+ "' email " +t1.getEmail()+"' password " +t1.getPassword()+"' phoneNumber "+t1.getPhoneNumber()+"' dateN "+t1.getDateN()+ "WHERE nom = '"+t1.getNom()+"')";
                    
           Statement stm =cnx.createStatement();
       
      stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
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
