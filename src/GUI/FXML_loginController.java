/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXCheckBox;
import entities.Personne;
import entities.User;
import javafx.scene.Cursor;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.ServicePersonne;
import utils.MyDb;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_loginController implements Initializable {

    @FXML
    private TextField eName;
    @FXML
    private PasswordField eKey;
    @FXML
    private Label lblErrors;
    @FXML
    private Button eLogin;
    @FXML
    private Hyperlink register;
    @FXML
    private JFXCheckBox rm;
    /// -- 
    Connection cnx =MyDb.getInstance().getCnx();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    Preferences preferences;
    
    
    @FXML
    private Hyperlink fp;
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleLienAction(MouseEvent event) throws IOException{
        if (event.getSource() == register) {
            //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_add.fxml")));
                    stage.setScene(scene);
                    stage.show();
        }
    }
    @FXML
    public void handleButtonAction(MouseEvent event) {
        ServicePersonne sp = new ServicePersonne();
        Personne pr=new Personne();
        String username = eName.getText();
        String password = eKey.getText();
            utils.User.UserNetsed u = new utils.User.UserNetsed();

       

        if (event.getSource() == eLogin) {
            //login here
//            if (logIn().equals("Success")) {
                     
               /* if(rm.isSelected()){
             
                    preferences.put("username", eName.getText());
                    preferences.put("password", eKey.getText());
                    
                }*/
            try
             {
                   Personne userValidate = sp.auth(username,password);
                    u.setP(userValidate);
                    if(userValidate.getRole().equals("ADMIN"))
                    {
                        System.out.println("Admin's Home");
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        Stage stage1= (Stage) rm.getScene().getWindow();
                        //stage.setMaximized(true);
                        stage.close();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_DashboardStudent.fxml")));
                        stage.setScene(scene);
                        stage1.setScene(scene);
                   
                       stage.show();
                       stage1.show();
                    }
                    else if(userValidate.getRole().equals("FORMATEUR"))
                    {
                        System.out.println("FORMATEUR's Home");
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        Stage stage1= (Stage) rm.getScene().getWindow();
                        //stage.setMaximized(true);
                        stage.close();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_Reset.fxml")));
                        stage.setScene(scene);
                        stage1.setScene(scene);
                   
                       stage.show();
                       stage1.show();

                        
                    }
                    else if(userValidate.getRole().equals("APPRENANT"))
                    {
                        System.out.println("APPRENANT's Home");
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        Stage stage1= (Stage) rm.getScene().getWindow();
                        //stage.setMaximized(true);
                        stage.close();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_Editprofil.fxml")));
                        stage.setScene(scene);
                        stage1.setScene(scene);
                   
                       stage.show();
                       stage1.show();

                        
                    }
                    else
                    {
                        System.out.println("Error message = "+userValidate);
                        
                        
                    }
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                catch (Exception e2)
                {
                    e2.printStackTrace();
                }

                    
//                try {
//                    
//                    //add you loading or delays - ;-)
//                    Node node = (Node) event.getSource();
//                    Stage stage = (Stage) node.getScene().getWindow();
//                    Stage stage1= (Stage) rm.getScene().getWindow();
//                    //stage.setMaximized(true);
//                    stage.close();
//                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_DashboardStudent.fxml")));
//                    stage.setScene(scene);
//                    stage1.setScene(scene);
//                   
//                    stage.show();
//                    stage1.show();
//                    
//
//                } catch (IOException ex) {
//                    System.err.println(ex.getMessage());
//                }
//                

            /*}
            else {
                preferences.put("username", "");
                preferences.put("password", "");
                 }*/
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        if (cnx == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
        
        preferences = Preferences.systemNodeForPackage(FXML_loginController.class);
        if(preferences != null){
            if(preferences.get("username",null) != null && !preferences.get("username",null).isEmpty()){
              eName.setText(preferences.get("username", null));
              eKey.setText(preferences.get("password", null));
            }
        }
    }    
  
     //we gonna use string to check for status
    private String logIn() {
        String status = "Success";
        String username = eName.getText();
        String password = eKey.getText();
        if(username.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            
            //query
            String sql = "SELECT * FROM users Where username = ? and password = ?";
            try {
                preparedStatement = cnx.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    User u=new User();
                    u.setId(0);
                    setLblError(Color.TOMATO, "Enter Correct name/Password");
                    status = "Error";
                } else {
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
            
        }
        
        
        return status;
    }
    
    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    @FXML
    private void forgetPass(MouseEvent event) {
        
        fp.setCursor(Cursor.HAND);
    }

    @FXML
    private void exit(MouseEvent event) {
    }

    @FXML
    private void passfr(MouseEvent event) throws IOException {
        if (event.getSource() == fp) {
            //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_Forgotpass.fxml")));
                    stage.setScene(scene);
                    stage.show();
        }
        
    }


    
 
    
    

    
    
}
