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
      Date date = new Date();  
   @Override
   public void ajouter(Exercice t) {
       try {
            String qry ="INSERT INTO `personne`( `date_ceation`, `contenu`) VALUES ('"+date.toString()+"','"+t.getContenu()+"')";
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
             exer.setContenu(rs.getString("contenu"));
             exer.setDate_creation(rs.getDate("date_creation"));
         exercices.add(exer);
          }
           
           
         
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
       }
      return exercices;
   }

 

 
    @Override
    public void modifier(Exercice t) {
         //To change body of generated methods, choose Tools | Templates.
         
         
    }

    @Override
    public void supprimer(Exercice t) {
       //To change body of generated methods, choose Tools | Templates.
       
       
       
       
       
    }
    
    public int getExerciceById(Exercice t){
        
        return 0;
        
    }
   
}
