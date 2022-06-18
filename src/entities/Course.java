/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author mabba
 */
public class Course {
    private  int id_course;
    private String contenu;
    private Date date_creation;
    private Date date_modif;
    private String type_course;
    private int id_createur;
    private int id_categories;

    public Course() {
    }

    public Course(int id_course, String contenu, Date date_creation, Date date_modif, String type_course, int id_createur, int id_categories) {
        this.id_course = id_course;
        this.contenu = contenu;
        this.date_creation = date_creation;
        this.date_modif = date_modif;
        this.type_course = type_course;
        this.id_createur = id_createur;
        this.id_categories = id_categories;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modif() {
        return date_modif;
    }

    public void setDate_modif(Date date_modif) {
        this.date_modif = date_modif;
    }

    public String getType_course() {
        return type_course;
    }

    public void setType_course(String type_course) {
        this.type_course = type_course;
    }

    public int getId_createur() {
        return id_createur;
    }

    public void setId_createur(int id_createur) {
        this.id_createur = id_createur;
    }

    public int getId_categories() {
        return id_categories;
    }

    public void setId_categories(int id_categories) {
        this.id_categories = id_categories;
    }
     @Override
   public String toString() {
        return "Course{" + "id=" + id_course + 
                ", conetnu=" + contenu + ", date creation="
                + date_creation + ", date modification" + date_modif +", type de course" + type_course
                + ", id_createur" + id_createur + ", id_categories"+ id_categories;
   }
   
    
    
    
}
