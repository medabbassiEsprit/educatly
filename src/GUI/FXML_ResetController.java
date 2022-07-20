/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.MyDb;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_ResetController implements Initializable {

    @FXML
    private AnchorPane APaneR;
    @FXML
    private Label btn_exit1;
    @FXML
    private JFXTextField pass;
    @FXML
    private JFXButton verifier;
    @FXML
    private JFXTextField confirmpass;
    
    
     Connection con = null;
     ResultSet rs = null;
     PreparedStatement pst = null ;
     Personne p = new Personne();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void verif_btn(ActionEvent event)  {
       
       if (event.getSource() == verifier) {
            //login here
            if (Reset().equals("Success")) {
                try {
                Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_login.fxml")));
                    stage.setScene(scene);
                    stage.show();
               } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
    }
       }
    }
    
    
    
    
     private String Reset() {
        String status = "Success";
         if(pass.getText().equals(confirmpass.getText())){
            try{
                
                String qry= "UPDATE users SET password=? WHERE username="+p.getUsername();
                con = MyDb.getCnx();
                pst=con.prepareStatement(qry);
                pst.setString(1, p.getPassword());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reset Successfully");
             }
           catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex);
           }}
            else {
                    JOptionPane.showMessageDialog(null, "password do not match ");
                 }
        
        return status;
     }
}
