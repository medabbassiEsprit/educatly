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
public class Exercice {
    private int id_exrecice;
    private Date date_creation;
    private String contenu;

    public Exercice() {
    }

    public Exercice(int id_exrecice, Date date_creation, String contenu) {
        this.id_exrecice = id_exrecice;
        this.date_creation = date_creation;
        this.contenu = contenu;
    }

    public int getId_exrecice() {
        return id_exrecice;
    }

    public void setId_exrecice(int id_exrecice) {
        this.id_exrecice = id_exrecice;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    @Override 
    public String toString(){
        return "date de creation"+ date_creation + "conetnu" + contenu;
    }
    
}
