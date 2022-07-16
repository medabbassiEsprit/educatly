/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Personne;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ServicePersonne;
import utils.MyDb;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_addController implements Initializable {

    @FXML
    private AnchorPane APane;
    @FXML
    private JFXButton register;
    @FXML
    private Label btn_exit;
    @FXML
    private JFXButton btnU;
    @FXML
    private JFXTextField imagePath;
    @FXML
    private AnchorPane APaneR;
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
    private JFXButton register1;
    @FXML
    private Label btn_exit1;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXDatePicker dateN;
    @FXML
    private JFXButton next;
    
    final FileChooser fc = new FileChooser();  
    List<File> files = null;
    String path= null ;
    
    Connection cnx =MyDb.getInstance().getCnx();
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list=FXCollections.observableArrayList("APPRENANT","FORMATEUR");

         role.setItems(list);
         role.setValue("Role");
         next.setVisible(false);
         APane.setVisible(false);
    }    

    @FXML
    private void add_personne(ActionEvent event) {
        
         if (event.getSource() == register) {
             
            if (addF().equals("Success")) {
                
                JOptionPane.showMessageDialog(null, "Register succes");
                

            }
         }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnFile(ActionEvent event) {
        
        fc.setTitle("choose file");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(
        //new FileChooser.ExtensionFilter("All File","*.*"),
        //new FileChooser.ExtensionFilter("Text File","*.txt"),
        new FileChooser.ExtensionFilter("Pdf File","*.pdf"));
       // List<File> files=fc.showOpenMultipleDialog(null);
        File files = fc.showOpenDialog(null);
        
        //for(int i=0 ; i<files.size();i++){
       // if(files != null ){
          // listF.getItems().add(files.get(i));
             if (files != null) {
                    
                    path =files.getAbsolutePath();
                    imagePath.setText(path);
                }
          
            //listF.appendText(files.get(i).getAbsolutePath()+ "\n");
          
        else {
            System.out.println("File Invalid");
        }
        
    }

    @FXML
    private void change_role(ActionEvent event) {
        if("FORMATEUR".equals(role.getSelectionModel().getSelectedItem())){
            next.setVisible(true);
            register.setVisible(false);
        } else {
             next.setVisible(false);
            register.setVisible(true);
        }
    }

    @FXML
    private void register_personne(ActionEvent event) {
         if (event.getSource() == register1) {
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
    private void next_btn(ActionEvent event) {
        
         if (event.getSource() == next) {
            //login here
            APane.setVisible(true);
            APaneR.setVisible(false);
            register.setVisible(true);
    }
    }
    
    
    public String add() {
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
    
     private String addF(){
         
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
        String uploadF = imagePath.getText();
        if(name.isEmpty() || Pprenom.isEmpty() || Username.isEmpty() || Email.isEmpty() || Pwd.isEmpty() || Rrole.isEmpty() || uploadF.isEmpty()) {
          
        } else {
            
            
            sp.ajouterF(new Personne
                              (0,nom.getText(),prenom.getText(),username.getText(),email.getText(),password.getText(),phoneNumber.getText(),
                                      sqlDate,
                                      role.getSelectionModel().getSelectedItem(),imagePath.getText()
                                      
                              ));
                              
         } 
         
         
        return status;
     }
}
