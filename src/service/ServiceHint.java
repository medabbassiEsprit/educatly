/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Aide;
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
public class ServiceHint  implements IService<Aide>{
     Connection cnx =MyDb.getInstance().getCnx();
      Date date = new Date();  

    @Override
    public void ajouter(Aide t) {
         try {
            String qry ="INSERT INTO `aide`(`contenu`, `id_apprenant`, `id_exercice`) VALUES ('"+t.getContenu()+"','"+t.getId_apprenant()+"','"+t.getId_exercice()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aide> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Aide t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Aide t) {
         try {
           String qry ="DELETE FROM `aide` WHERE `id_aide`="+t.getId_aide()+"";
             Statement stm =cnx.createStatement();
             stm.executeUpdate(qry); 
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
    
     public Aide getHintByExerciceId(int id){
        Aide hint = new Aide();
                    try {
           String qry ="Select * FROM `exercice` WHERE `id_exercice`="+id+"";
            Statement stm =cnx.createStatement();
            ResultSet rs=  stm.executeQuery(qry);
             while(rs.next()){
                 hint.setId_aide(rs.getInt("id_aide"));
                 hint.setContenu(rs.getString("contenu"));
                 hint.setId_apprenant(rs.getInt("id_apprenant"));
                 hint.setId_exercice(rs.getInt("id_exercice"));
                 
                          
          }
           
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        
        return hint;
    }
     
     
    
}
