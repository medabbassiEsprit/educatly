/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Course;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.MyDb;

/**
 *
 * @author mabba
 */
public class ServiceCourse implements IService<Course> {
       Connection cnx =MyDb.getInstance().getCnx();
      Date date = new Date();  
    @Override
    public void ajouter(Course t) {
          try {
            String qry ="INSERT INTO `course`( `date_ceation`, `contenu`) VALUES ('"+date.toString()+"','"+t.getContenu()+"')";
            Statement stm =cnx.createStatement();
       
       stm.executeUpdate(qry);
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
       }
        
        
        
        
    }

    @Override
    public List<Course> afficher() {
        List<Course> course = new ArrayList();
        return course;
    }

    @Override
    public void modifier(Course t) {
    }

    @Override
    public void supprimer(Course t) {
    }
    
    
    public int getCourseById(Course t){
    
        return 0;
    
    }
    
}
