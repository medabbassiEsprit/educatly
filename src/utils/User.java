/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Personne;

/**
 *
 * @author hp
 */
public class User extends Personne{
        
        
  public static   Personne  p = new Personne();
   public static String email;

 
    // Non-static nested class -
    // also called Inner class

    public User() {
    }

    

   
      // Static nested class
    public static class UserNetsed {
 
        // Only static members of Outer class
        // is directly accessible in nested
        // static class

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            User.email = email;
        }
            
            public  Personne getP() {
                     return p;
    }

            public  void setP(Personne p) {
                User.p = p;
    }
    }
   
}
