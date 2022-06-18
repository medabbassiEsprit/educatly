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
    private int id_exercice;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu, int id_exercice) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.id_exercice = id_exercice;
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

    public int getId_exercice() {
        return id_exercice;
    }

    public void setId_exercice(int id_exercice) {
        this.id_exercice = id_exercice;
    }
    @Override 
    public String toString(){
    return "conetnu"+ contenu + "id_exercice"+ id_exercice;}
    
}
