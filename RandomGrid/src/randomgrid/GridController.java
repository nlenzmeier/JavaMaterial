/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dale
 */
public class GridController implements Initializable {

    @FXML
    private GridPane gridPane;
    
    private final int NUMROWS = 40;
    private final int NUMCOLS = 40;
    
    private double gridWidth;
    private double gridHeight;
    
    private double rectWidth;
    private double rectHeight;
    
    private final Color[] colors = {Color.CORAL, Color.DEEPPINK, Color.BISQUE, Color.AZURE, Color.SEAGREEN};
    
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void ready(Stage stage) {
        this.stage = stage;

        ChangeListener<Number> listener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                
                render();
            }
        };
        
        //Using lambda expression:
//        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
//            render();
//        };
        
        gridPane.widthProperty().addListener(listener);
        gridPane.heightProperty().addListener(listener);
        render();
    }
    
    protected void render() {
        gridPane.getChildren().clear();
        gridWidth = gridPane.getWidth();
        gridHeight = gridPane.getHeight();
        
        rectWidth = Math.ceil(gridWidth / NUMCOLS);
        rectHeight = Math.ceil(gridHeight / NUMROWS);
        
        Random rn = new Random();
        int numColors = colors.length;
        
        for (int row = 0; row < NUMROWS; row++) {
            for (int col = 0; col < NUMCOLS; col++) {
                Color color = colors[rn.nextInt(numColors)];
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }       
    }
    
    
    @FXML
    private void handleRefresh(ActionEvent event) {
        
        render();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        gridPane.getChildren().clear();
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("RandomGrid");
        alert.setContentText("This application was developed by Dale Musser for CS3330 at the University of Missouri.  This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        alert.showAndWait();
    }
    
}
