/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nicolle
 */
public class Nalyv2Notifier extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField titleField = new TextField();
        Button btn = new Button();
        btn.setText("Notify");
        btn.setOnAction((ActionEvent event) -> {
            titleField.setText("You have been notified!");
        });
        
        Button cbtn = new Button();
        cbtn.setText("Clear");
        cbtn.setOnAction((ActionEvent event) -> {
            titleField.setText(" ");
        });
        
        
        
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.add(titleField, 0, 0);
        root.add(btn, 1, 0);
        root.add(cbtn, 1, 1);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
