/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import entities.Personne;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.swing.JTextField;
import service.ServicePersonne;
import sun.util.calendar.BaseCalendar.Date;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_RegisterController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phoneNumber;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXComboBox<String> role;
    @FXML
    private Label btn_exit;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXDatePicker dateN;
    @FXML
    private Button register;
   
                         
    /**
     * Initializes the controller class.
     */
    
     // Converter
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ObservableList<String> list=FXCollections.observableArrayList("APPRENANT","FORMATEUR");

         role.setItems(list);
         role.setValue("Role");
       

       
    } 
    @FXML
    private void register_personne(ActionEvent event) {
          if (event.getSource() == register) {
            //login here
            if (add().equals("Success")) {
                try {

                    //add you loading or delays - ;-)
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
    
  
    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.exit(0);
    }

   
    private String add() {
        String status = "Success";
        ServicePersonne sp = new ServicePersonne();
        String name =nom.getText();
        String Pprenom = prenom.getText();
        String Username = username.getText();
        String Email = email.getText();
        String Pwd = password.getText();
        ObservableList<String> Rrole= role.getItems();
        java.util.Date date = 
    java.util.Date.from(dateN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
         if(name.isEmpty() || Pprenom.isEmpty() || Username.isEmpty() || Email.isEmpty() || Pwd.isEmpty() || Rrole.isEmpty()) {
            status = "Error";
        } else {
            sp.ajouter(new Personne
                              (0,nom.getText(),prenom.getText(),username.getText(),email.getText(),password.getText(),phoneNumber.getText(),
                                      sqlDate,
                                      role.getSelectionModel().getSelectedItem()
                              ));
         }
         
        return status;
            
            
        }

    
    
}
