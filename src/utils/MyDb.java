/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayssa
 */
public class MyDb {
final private String URL ="jdbc:mysql://localhost:3306/educatly";
final private String USERNAME ="root";
final private String PWD ="";
 static private Connection cnx;
static private MyDb instance;
 
private MyDb(){
 
    try {
        cnx =DriverManager.getConnection(URL, USERNAME, PWD);
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
   }
 
}
 
 static public MyDb getInstance (){
   if (instance == null)
      instance=new MyDb();
    
     return instance;
 }
static public  Connection getCnx(){
    return cnx;
}
}
