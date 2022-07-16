/*
 * To change this license header, choose License Headers in Project Properties.
 *
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import java.sql.Date;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;



/**
 *
 * @author Mayssa
 */

  enum roleEnum{
        APPRENANT,FORMATEUR
    };

public class Personne {
    private int id;
    private String nom ,prenom,username,email,password,role,phoneNumber,file_formateur;
    private Date dateN;
    
    
    
    public Personne() {
       
    }
    
    public Personne(int id, String nom, String prenom, String username, String email, String password, String phoneNumber, Date dateN,String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateN = dateN;
        this.role=role;
    }

    public Personne(String file_formateur) {
        this.file_formateur = file_formateur;
    }

    public Personne(int id, String nom, String prenom, String username, String email, String password,String phoneNumber, Date dateN, String role, String file_formateur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateN = dateN;
        this.role = role;
        this.file_formateur = file_formateur;
        
    }

   

  

   

    public String getFile_formateur() {
        return file_formateur;
    }

    public void setFile_formateur(String file_formateur) {
        this.file_formateur = file_formateur;
    }

    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    /*public roleEnum[] getRole() {
        return role;
    }*/

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + ", phoneNumber=" + phoneNumber + ", file_formateur=" + file_formateur + ", dateN=" + dateN + '}';
    }

    
   
  
    

    

}
