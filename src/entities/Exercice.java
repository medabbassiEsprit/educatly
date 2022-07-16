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
    private String date_creation;
    private String titre;
    private String contenu;
    private String solution;
    private int solutionDeux;

    public Exercice() {
    }

    public Exercice(int id_exrecice, String date_creation,String titre, String contenu,String solution,int solutionDeux) {
        this.id_exrecice = id_exrecice;
        this.date_creation = date_creation;
        this.titre=titre;
        this.contenu = contenu;
        this.solution = solution;
        this.solutionDeux=solutionDeux;
    }

    public int getId_exrecice() {
        return id_exrecice;
    }

    public void setId_exrecice(int id_exrecice) {
        this.id_exrecice = id_exrecice;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getSolution() {
        return solution;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getSolutionDeux() {
        return solutionDeux;
    }

    public void setSolutionDeux(int solutionDeux) {
        this.solutionDeux = solutionDeux;
    }
    
    
    
    @Override 
    public String toString(){
        return " Service ==> \n date de creation :"
                + date_creation 
                + " \n Titre: " + titre
                + " conetnu :" + contenu+"\n" +solution +"\n" +solutionDeux;
    }
    
}
