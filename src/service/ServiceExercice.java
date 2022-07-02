/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.MyDb;

/**
 *
 * @author Mohamed
 */
public class ServiceExercice implements IService<Exercice>{
    Connection cnx =MyDb.getInstance().getCnx();
      java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
      Timestamp ts = new Timestamp(-10000);


   @Override
   public void ajouter(Exercice t) {
       try {
            String qry ="INSERT INTO `exercice`( `titreExercice`,`contenu`,`solution`,`solutionDeux`) VALUES ('"+t.getTitre()+"','"+t.getContenu()+"','"+t.getSolution()+"','"+t.getSolutionDeux()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
      
  }

    @Override
   public List<Exercice> afficher() {
     List<Exercice> exercices = new ArrayList();
        
      try {
           String qry ="select * from exercice ";
          
          Statement stm =cnx.createStatement();
          ResultSet rs=  stm.executeQuery(qry);
          while(rs.next()){
             Exercice exer = new Exercice();
             exer.setId_exrecice(rs.getInt("id_exercice"));
             exer.setDate_creation(rs.getString(2));
             exer.setTitre(rs.getString("titreExercice"));
             exer.setContenu(rs.getString("contenu"));
             exer.setSolution(rs.getString("solution"));
             exer.setSolutionDeux(rs.getInt(6));
             
         exercices.add(exer);
          }
           
           
         
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
       }
      System.out.println(exercices);
      return exercices;
   }

 

 
    @Override
    public void modifier(Exercice t) {
         //To change body of generated methods, choose Tools | Templates.
     List<Exercice> exercices = new ArrayList();

               try {
           String qry ="UPDATE `exercice` SET `titreExercice`='"+t.getTitre()+"',`contenu`='"+t.getContenu()+"',`solution`='"+t.getSolution()+"',`solutionDeux`='"+t.getSolutionDeux()+"' WHERE `id_exercice` = `"+t.getId_exrecice()+"`";
          
          Statement stm =cnx.createStatement();
          ResultSet rs=  stm.executeQuery(qry);
          while(rs.next()){
             Exercice exer = new Exercice();
             exer.setId_exrecice(rs.getInt("id_exercice"));
             exer.setDate_creation(rs.getString(2));
             exer.setTitre(rs.getString("titreExercice"));
             exer.setContenu(rs.getString("contenu"));
             exer.setSolution(rs.getString("solution"));
             exer.setSolutionDeux(rs.getInt(6));
             
         exercices.add(exer);
           
          }
           
           
         
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
       }
      
   }
         
         
         
    

    @Override
    public void supprimer(Exercice t) {
       //To change body of generated methods, choose Tools | Templates.
      

       try {
           String qry ="DELETE FROM `exercice` WHERE `id_exercice`="+t.getId_exrecice()+"";
             Statement stm =cnx.createStatement();
             stm.executeUpdate(qry); 
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       
     
       
    }
    
    public Exercice getExerciceById(int id){
        Exercice exerc = new Exercice();
            try {
           String qry ="Select * FROM `exercice` WHERE `id_exercice`="+id+"";
            Statement stm =cnx.createStatement();
            ResultSet rs=  stm.executeQuery(qry);
             while(rs.next()){
            
             exerc.setId_exrecice(rs.getInt("id_exercice"));
             exerc.setDate_creation(rs.getString(2));
             exerc.setTitre(rs.getString("titreExercice"));
             exerc.setContenu(rs.getString("contenu"));
             exerc.setSolution(rs.getString("solution"));
             exerc.setSolutionDeux(rs.getInt(6));
             
         
           
          }
           
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
          System.out.println(exerc);    
        return exerc;
        
    }
   
}
