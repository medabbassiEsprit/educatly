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
public class Paiement {
    private int id_paiement;
    private int id_user;

    public Paiement() {
    }

    public Paiement(int id_paiement, int id_user) {
        this.id_paiement = id_paiement;
        this.id_user = id_user;
    }

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
   @Override 
    public String toString(){
        return "is paiement"+ id_paiement + "id user" + id_user;
    }
    
}
