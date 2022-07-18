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
   private static Personne user;
   
   
    public User() {
        super();
    }
    
    
    public static Personne getUser() {
        return user;
    }

    public static void setUser(Personne user) {
        User.user = user;
    }
    
    
}
