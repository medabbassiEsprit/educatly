/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Exercice;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import service.ServiceExercice;

/**
 *
 * @author mabba
 */
public class FXML_addExericeController implements Initializable {
    
    @FXML
    private FontAwesomeIconView Eprofil;

    @FXML
    private Label btn_exit;

    @FXML
    private Text logout;

    @FXML
    private JFXButton btn_add;
      @FXML
    private JFXButton autre;

      @FXML
    private HBox succes;
    @FXML
    private TextField titre;

    @FXML
    private TextArea contenu;

    @FXML
    private TextField solOne;

    @FXML
    private TextField solTwo;

    String title,content,SolutionOne;
    int SolutionTwo;
    
    
     Exercice exerc =  new Exercice();
      ServiceExercice srvExer =  new ServiceExercice();
 

    @FXML
    void addExercice(ActionEvent event) {
       
        
       if(event.getSource() == btn_add){
       exerc.setTitre(titre.getText());
        exerc.setContenu(contenu.getText());
        exerc.setSolution(solOne.getText());
        exerc.setSolutionDeux(Integer.valueOf(solTwo.getText()));
       succes.setVisible(true);
        srvExer.ajouter(exerc);
       }
        

    }
     @FXML
    void cleanSpace(ActionEvent event) {
       
        
       if(event.getSource() == autre){
       titre.setText("");
     contenu.setText("");
    solOne.setText("");
     solTwo.setText("");
       succes.setVisible(false);
       
       }
        

    }

   

    @FXML
    void handleButtonAction(MouseEvent event) {
       
        
        
       
        
        
        
        

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
        succes.setVisible(false);
    }
    
    
    
    
    
}
