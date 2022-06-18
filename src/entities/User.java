/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mabba
 */
public class User {
   private int id ;
   private String nom;
   private String prenom;
   private String username;
   private String email;
   private String password;
   private String role;
   private String statut;
   private String[] list_course;
   private String[] list_exercice;
   private int rang;

    public User() {
    }

    public User(int id, String nom, String prenom, String username, String email, String password, String role, String statut, String[] list_course, String[] list_exercice, int rang) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.statut = statut;
        this.list_course = list_course;
        this.list_exercice = list_exercice;
        this.rang = rang;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String[] getList_course() {
        return list_course;
    }

    public void setList_course(String[] list_course) {
        this.list_course = list_course;
    }

    public String[] getList_exercice() {
        return list_exercice;
    }

    public void setList_exercice(String[] list_exercice) {
        this.list_exercice = list_exercice;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
     @Override
   public String toString() {
        return "User{" + "id=" + id + 
                ", nom=" + nom + ", prenom="
                + prenom + ", username" + username +", email" + email
                + ", role" + role;
   }
   
    
    
}
