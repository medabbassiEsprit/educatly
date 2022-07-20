/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entities.Aide;
import entities.Exercice;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import service.ServiceExercice;
import service.ServiceHint;

/**
 * FXML Controller class
 *
 * @author mabba
 */
public class FXML_correctionExerciceController implements Initializable {

   @FXML
    private Label btn_exit;

    @FXML
    private JFXButton verif;
    @FXML
    private JFXButton addCmnt;

    @FXML
    private JFXButton hint;

    @FXML
    private Text titreExerice;

    @FXML
    private Text contenuExerice;

    @FXML
    private TextField solOne;

    @FXML
    private TextField solTwo;

    @FXML
    private HBox succes;

    @FXML
    private HBox fail;
    
       @FXML
    private HBox fieldSolTwo;

    @FXML
    private HBox fieldSolOne;
        @FXML
    private HBox retry;

    @FXML
    private Button retryBtn;
        @FXML
    private VBox aideWindow;
  
    @FXML
    private Text HintContent;
    
    String fieldOne ;
    String fieldTwo;
    
    @FXML
    void addCommentaire(ActionEvent event) {
        
        

    }

      @FXML
    void verifResponses(ActionEvent event) {
             if(event.getSource() == verif){
                 
              if(solOne.getText().equals(fieldOne)  || solTwo.getText().equals(solTwo) ){
                    succes.setVisible(true);

              } else {
                  fail.setVisible(true);
                 retry.setVisible(true);

                  
              }
                 
                 
     
       }
        
        
    }

    @FXML
    void handleButtonAction(MouseEvent event) {
        
        
        
        

    }
    
    @FXML
    void retry(ActionEvent event) {
        solOne.setText("");
        solTwo.setText("");
           fail.setVisible(false);
                 retry.setVisible(false);
        
        

    }

    @FXML
    void startHint(ActionEvent event) {
        
        Aide hint ;
        ServiceHint srvcHint = new ServiceHint();
        hint = srvcHint.getHintByExerciceId(exerc.getId_exrecice());
        aideWindow.setVisible(true);
        HintContent.setText(hint.getContenu());


        
        
        

    }
    
       Exercice exerc ;
      ServiceExercice srvExer =  new ServiceExercice();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                succes.setVisible(false);
               fail.setVisible(false);
               retry.setVisible(false);
               aideWindow.setVisible(false)
                       ;
                exerc = srvExer.getExerciceById(30);
                titreExerice.setText(exerc.getTitre());
                contenuExerice.setText(exerc.getContenu());
              
          
            
               fieldOne = exerc.getSolution();
               fieldTwo = String.valueOf(exerc.getSolutionDeux());
               
               if(fieldOne.equals("")){
                   fieldSolOne.setOpacity(0);
               } else if(fieldTwo.equals(0)) {
                   fieldSolTwo.setOpacity(0);

               }
               

        // TODO
    }    

   
    
}
