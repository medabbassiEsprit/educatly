/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Personne;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import static java.util.stream.Collectors.toList;
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
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_ForgotpassController implements Initializable {

    @FXML
    private AnchorPane APaneR;
    @FXML
    private JFXTextField email;
    @FXML
    private Label btn_exit1;
    @FXML
    private JFXButton verif;
    @FXML
    private JFXTextField code;
    @FXML
    private JFXButton Envoyer;
    Component rootPane;
    
    int randomcode;
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
    private void verif_btn(ActionEvent event) throws IOException {
       
        if(Integer.valueOf(code.getText())== randomcode  ){
                    Personne rs =new Personne(email.getText());
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXML_Reset.fxml")));
                    stage.setScene(scene);
                    stage.show();
        }
        else {
            JOptionPane.showMessageDialog(null, "code do not match");
        }
        
    }

    @FXML
    private void envoyer_btn(ActionEvent event) {
        utils.User.UserNetsed u = new utils.User.UserNetsed();
        
        try{
        Random rand = new Random();
        randomcode = rand.nextInt(999999);
        String host = "smtp.gmail.com";
        String user = "mayssa.khalifa@esprit.tn";
        String pass = "bhwztbgsbynvkjvb";
        String to = email.getText();
        u.setEmail(to);
        String subject ="Reseting code ";
        String message ="your reset code is "+randomcode;
         
        boolean sessionDebug = false;
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "host");
        //props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");     
        props.put("mail.smtp.user","user"); 
        props.put("mail.smtp.port", "25"); 
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.EnableSSL.enable","true");
         

//        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");   
//        props.setProperty("mail.smtp.port", "465");   
//        props.setProperty("mail.smtp.socketFactory.port", "465"); 
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession= Session.getDefaultInstance(props,null);
        mailSession.setDebug(sessionDebug);
        Message msg= new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] adress = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, adress);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport= mailSession.getTransport("smtp");
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        JOptionPane.showMessageDialog(null, "code envoyer");
        //Session session = Session.getInstance(props, null);
    //session.setDebug(true);

//    Message msg = new MimeMessage(session);
//    msg.setFrom(new InternetAddress(user));
//
//    // To get the array of addresses
//    InternetAddress [] adress = {new InternetAddress(to)};
//    msg.setRecipients(Message.RecipientType.TO, adress);
//
//    msg.setSubject(subject);
//    msg.setContent(message, "text/html");
//
//    Transport transport = session.getTransport("smtp");
//    try {
//        transport.connect(host, user, pass);
//        transport.sendMessage(msg, msg.getAllRecipients());
//    } finally {
//        transport.close();
//    }
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
    
}
