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
import service.ServicePersonne;
import utils.MyDb;
import utils.User;

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
     User.UserNetsed u = new User.UserNetsed();
     String pr = u.getEmail();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("pr===>"+pr);
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void verif_btn(ActionEvent event)  {
       ServicePersonne sp = new ServicePersonne();
        Personne p = new Personne();
        
        String email= pr;
        String password=pass.getText();
        System.out.println("=====>"+email + password);
      
        
       if (event.getSource() == verifier) {
            //login here
           if(pass.getText().equals(confirmpass.getText())){
               
                try {
                sp.updatePassword(password,email);
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
    
    
    
    
//     private Personne Reset(String password,String Username) {
//        String status = "Success";
//         if(pass.getText().equals(confirmpass.getText())){
//            try{
//                
//                String qry= "UPDATE `users` SET `password`="+"'password' WHERE username="+Username;
//                con = MyDb.getCnx();
//                pst=con.prepareStatement(qry);
//                pst.setString(1, p.getPassword());
//                pst.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Reset Successfully");
//             }
//           catch(Exception ex){
//               JOptionPane.showMessageDialog(null, ex);
//           }}
//            else {
//                    JOptionPane.showMessageDialog(null, "password do not match ");
//                 }
//        
//        return status;
//     }
}
