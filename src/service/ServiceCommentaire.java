/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Commentaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import utils.MyDb;

/**
 *
 * @author mabba
 */
public class ServiceCommentaire implements IService<Commentaire> {
     Connection cnx =MyDb.getInstance().getCnx();
      Date date = new Date();  

    @Override
    public void ajouter(Commentaire t) {
        
          try {
            String qry ="INSERT INTO `commentaire`(`contenu`, `id_exercice`, `id_user`) VALUES ('"+t.getContenu()+"','"+t.getExerciceId()+"','"+t.getPersonId()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
        
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Commentaire t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Commentaire t) {
       try {
           String qry ="DELETE FROM `exercice` WHERE `id_exercice`="+t.getId_commentaire()+"";
             Statement stm =cnx.createStatement();
             stm.executeUpdate(qry); 
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       } //To change body of generated methods, choose Tools | Templates.
    }
    
    public Commentaire getCommentaireByExerciceId(int id){
        Commentaire cmnt = new Commentaire();
                    try {
           String qry ="Select * FROM `exercice` WHERE `id_exercice`="+id+"";
            Statement stm =cnx.createStatement();
            ResultSet rs=  stm.executeQuery(qry);
             while(rs.next()){
                 cmnt.setId_commentaire(rs.getInt("id_commentaire"));
                 cmnt.setContenu(rs.getString("contenu"));
                 cmnt.setExerciceId(rs.getInt("id_exercice "));
                 cmnt.setPersonId(rs.getInt("id_user"));
                          
          }
           
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        
        return cmnt;
    }
    public Commentaire getCommentaireByUserId(int id){
        Commentaire cmnt = new Commentaire();
                    try {
           String qry ="Select * FROM `exercice` WHERE `id_user`="+id+"";
            Statement stm =cnx.createStatement();
            ResultSet rs=  stm.executeQuery(qry);
             while(rs.next()){
                 cmnt.setId_commentaire(rs.getInt("id_commentaire"));
                 cmnt.setContenu(rs.getString("contenu"));
                 cmnt.setExerciceId(rs.getInt("id_exercice "));
                 cmnt.setPersonId(rs.getInt("id_user"));
                          
          }
           
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        
        return cmnt;
    }
    
    
    
    
    
}
