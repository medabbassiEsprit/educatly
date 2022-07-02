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
public class Aide {
    private int id_aide;
    private String contenu;
    private Personne id_apprenant;
    private Exercice id_exercice;
  

    public Aide() {
    }

    public Aide(int id_aide, String contenu, Personne id_apprenant, Exercice id_exercice) {
        this.id_aide = id_aide;
        this.contenu = contenu;
        this.id_apprenant = id_apprenant;
        this.id_exercice = id_exercice;
    }

    public Personne getId_apprenant() {
        return id_apprenant;
    }

    public void setId_apprenant(Personne id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public Exercice getId_exercice() {
        return id_exercice;
    }

    public void setId_exercice(Exercice id_exercice) {
        this.id_exercice = id_exercice;
    }

    public int getId_aide() {
        return id_aide;
    }

    public void setId_aide(int id_aide) {
        this.id_aide = id_aide;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

  
    
    @Override
    public String toString(){
    
    return "conetnu "+ contenu + "id apprenant" + id_apprenant + "id exercice"+ id_exercice;
    }
}
