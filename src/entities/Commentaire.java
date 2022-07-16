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
public class Commentaire {
    private int id_commentaire;
    private String contenu;
    private int exerciceId;
    private int personId;

    public Commentaire(int id_commentaire, String contenu, int id_exercice, int exerciceId, int personId) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
      
        this.exerciceId = exerciceId;
        this.personId = personId;
    }

    public int getExerciceId() {
        return exerciceId;
    }

    public void setExerciceId(int exerciceId) {
        this.exerciceId = exerciceId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    @Override 
    public String toString(){
    return "conetnu"+ contenu + "id_exercice"+ exerciceId;}

    
}
