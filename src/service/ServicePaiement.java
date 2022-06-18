/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Paiement;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import utils.MyDb;

/**
 *
 * @author mabba
 */
public class ServicePaiement implements IService<Paiement> {
       Connection cnx =MyDb.getInstance().getCnx();
      Date date = new Date();  

    @Override
    public void ajouter(Paiement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paiement> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Paiement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Paiement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
