/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Aide;
import entities.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDb;

/**
 *
 * @author mabba
 */
public class ServiceHint  implements IService<Aide>{
     Connection cnx =MyDb.getInstance().getCnx();

    @Override
    public void ajouter(Aide t) {
         try {
             //To change body of generated methods, choose Tools | Templates.
             String qry ="INSERT INTO `aide`( `contenu`, `id_apprenant`, `id_exercice`) VALUES ('"+t.getContenu()+"','"+t.getId_apprenant()+"','"+t.getId_exercice()+"')";
             Statement stm =cnx.createStatement();
             stm.executeUpdate(qry);

         } catch (SQLException ex) {
             Logger.getLogger(ServiceHint.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
    }

    @Override
    public List<Aide> afficher() {
            List<Aide> aide = new ArrayList();
          
            
         try {
                 String qry ="select * from aide  ";
                Statement stm= cnx.createStatement();
                ResultSet rs=  stm.executeQuery(qry);
                while(rs.next()){
                Aide hint= new Aide();
                hint.setId_aide(rs.getInt(1));
                hint.setContenu(rs.getString(2));
                aide.add(hint);
                }
                
         } catch (SQLException ex) {
             Logger.getLogger(ServiceHint.class.getName()).log(Level.SEVERE, null, ex);
         }
          
            
        return aide;
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
       } //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
