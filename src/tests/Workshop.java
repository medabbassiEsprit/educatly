/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hp
 */
public class Workshop extends Application {
    
    private double xOffset=0;
    private double yOffset=0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_login.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("/GUI/FXML_add.fxml"));
        
        Scene scene = new Scene(root);
        Scene scene1 = new Scene(root1);
        
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset=event.getSceneX();
                yOffset=event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX()- xOffset);
                stage.setY(event.getScreenY()- yOffset);
            }
        });        
        
        root1.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset=event.getSceneX();
                yOffset=event.getSceneY();
            }
        });
        
        root1.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX()- xOffset);
                stage.setY(event.getScreenY()- yOffset);
            }
        });
        
        stage.setScene(scene1);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      
}