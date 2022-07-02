/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML_RegfrController implements Initializable {

    @FXML
    private JFXButton register;
    @FXML
    private Label btn_exit;
    @FXML
    private JFXListView<File> listF;
    @FXML
    private JFXButton btnU;
    
    final FileChooser fc = new FileChooser();               


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register_personne(ActionEvent event) {
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
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("All File","*.*"),
        new FileChooser.ExtensionFilter("Text File","*.txt"),
        new FileChooser.ExtensionFilter("Pdf File","*.pdf"));
        List<File> files=fc.showOpenMultipleDialog(null);
        
        for(int i=0 ; i<files.size();i++){
        if(files != null ){
            listF.getItems().add(files.get(i));
            //listF.appendText(files.get(i).getAbsolutePath()+ "\n");
            
        }else {
            System.out.println("File Invalid");
        }
    }
    }
    
}
