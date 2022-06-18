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
public class Categorie {
    private int id_categorie;
    private String label;

    public Categorie() {
    }

    public Categorie(int id_categorie, String label) {
        this.id_categorie = id_categorie;
        this.label = label;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @Override
    public String toString (){
    return "label" + label;
    }
    
}
