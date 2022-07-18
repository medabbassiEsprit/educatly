/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entities.Personne;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ServicePersonne;
import utils.MyDb;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_EditprofilController implements Initializable {

    @FXML
    private Text logout;
    @FXML
    private Label btn_exit;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXDatePicker dateU;
    @FXML
    private JFXButton btnU;
    @FXML
    private Label userN;

    Connection cnx =MyDb.getInstance().getCnx();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private JFXTextField enter;
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
    private void Logout(MouseEvent event) throws IOException {
        logout.getScene().getWindow().hide();
       
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        //stage.setMaximized(true);
                        stage.close();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_login.fxml")));
                        stage.setScene(scene);
                        stage.show();
    }

    @FXML
    private void update(ActionEvent event) {
       
        if (event.getSource() == btnU) {
             
            if (add().equals("Success")) {
                
             Alert alert= new Alert(AlertType.INFORMATION);
             alert.setTitle("Update profil");
             alert.setHeaderText("Information");
             alert.setContentText("Profil bien changer ");
             alert.showAndWait();

            }
            else{
             Alert alert= new Alert(AlertType.ERROR);
             alert.setTitle("Update profil");
             alert.setHeaderText("Information");
             alert.setContentText("Profil ne pas changer ");
             alert.showAndWait();
            }
         }
       
           
           
       
        
        
        
        
    }
    
     public String add() {
        String status = "Success";
      /*    java.util.Date date = 
        java.util.Date.from(dateU.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());*/
        
        String Fname=firstname.getText();
        String Lname=lastname.getText();
        //String Date=dateU.getEditor().getText();
        String PhonNum=phone.getText();
        String Email= email.getText();
       
        ServicePersonne sp = new ServicePersonne();
        Personne p = new Personne();
        
        p.setNom(Fname);
        p.setPrenom(Lname);
       // p.setDateN(sqlDate);
        p.setEmail(Email);
        p.setPhoneNumber(PhonNum);
       
        sp.update(p);
        
        return status;
            
            
        }

    @FXML
    private void editPo(ActionEvent event) throws IOException, ParseException{
        
        String UserE=enter.getText();
        Personne U= ServicePersonne.getPersonneUser(UserE);
       
        userN.setText(U.getUsername());
        firstname.setText(U.getNom());
        lastname.setText(U.getPrenom());
       // dateU.setStyle(U.getDateN().toString());
        phone.setText(U.getPhoneNumber());
        email.setText(U.getEmail());
    }

  
    
}
