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
import utils.User;

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
    User.UserNetsed u = new User.UserNetsed();
    Personne pr = u.getP();
    @FXML
    private JFXTextField enter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userN.setText(pr.getUsername());
        
        firstname.setText(pr.getNom());
        lastname.setText(pr.getPrenom());
        phone.setText(pr.getPhoneNumber());
        email.setText(pr.getEmail());
        
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
        ServicePersonne sp = new ServicePersonne();
        Personne p = new Personne();
        String username = userN.getText();
        
        String Fname=firstname.getText();
        String Lname=lastname.getText();
        
        String PhonNum=phone.getText();
        String Email= email.getText();
      
        sp.update(Fname,Lname,PhonNum,Email,username);
       /* if (){
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
            }*/
        
  
    }
    

    @FXML
    private void editPo(ActionEvent event) throws IOException, ParseException{
        
        //userN.setText(U.getUsername());
        
    }

  
    
}
