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
public class Notifications {
    private int id_notif;
    private int id_formateur;
    private int id_apprenant;
    private int id_cours;
    private Date date_notifocation;

    public Notifications() {
    }

    public Notifications(int id_notif, int id_formateur, int id_apprenant, int id_cours, Date date_notifocation) {
        this.id_notif = id_notif;
        this.id_formateur = id_formateur;
        this.id_apprenant = id_apprenant;
        this.id_cours = id_cours;
        this.date_notifocation = date_notifocation;
    }

    public int getId_notif() {
        return id_notif;
    }

    public void setId_notif(int id_notif) {
        this.id_notif = id_notif;
    }

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }

    public int getId_apprenant() {
        return id_apprenant;
    }

    public void setId_apprenant(int id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public Date getDate_notifocation() {
        return date_notifocation;
    }

    public void setDate_notifocation(Date date_notifocation) {
        this.date_notifocation = date_notifocation;
    }
    @Override
    public String toString(){
    return "id formateur" + id_formateur+ ", id_apprenant"+ id_apprenant + ", id course" + id_cours+ "date de notification" + date_notifocation;
    }
    
    
    
}
