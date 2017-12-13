/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2checkers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nicolle
 */
public class BoardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private VBox vBox;
    
    private int numRows = 8;
    private int numCols = 8;
    
    //private final double anchorPaneWidth = anchorPane.getWidth();
    //private final double anchorPaneHeight = anchorPane.getHeight();
    
    private double rectWidth;
    private double rectHeight;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private Stage stage;
    CheckerBoard board;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
    }  
    
    public void ready(Stage stage){ 
        this.stage = stage;
        
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            if(lightColor == Color.RED && darkColor == Color.BLACK){
            vBox.getChildren().remove(anchorPane);
            board = new CheckerBoard(numRows, numCols, vBox.getWidth(), vBox.getHeight()-33);        
            anchorPane = board.build();
            vBox.getChildren().add(anchorPane);
            }
            else {
            vBox.getChildren().remove(anchorPane);
            board = new CheckerBoard(numRows, numCols, vBox.getWidth(), vBox.getHeight()-33, lightColor, darkColor);        
            anchorPane = board.build();
            vBox.getChildren().add(anchorPane);
            }
        };
        
        this.vBox.widthProperty().addListener(listener);
        this.vBox.heightProperty().addListener(listener);
                
        board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());       
        anchorPane = board.build();
        vBox.getChildren().add(anchorPane);
    }
    

       
    @FXML
    private void handle16(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        numCols = 16;
        numRows = 16;
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        anchorPane = board.build();   
        vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle10(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        numCols = 10;
        numRows= 10;
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        anchorPane = board.build();
        
        vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle8(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        numCols = 8;
        numRows = 8;
        //render();
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        anchorPane = board.build();
        
        vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle3(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        numCols = 3;
        numRows = 3;
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        anchorPane = board.build();
        
        vBox.getChildren().add(anchorPane);
    }
    
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("Clear");
        anchorPane.getChildren().clear();
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Nalyv2Checkers");
        alert.setContentText("This is a checkerboard application. "
                + "To change the color of the board, select Colors. "
                + "To change the size of the board, click Size and "
                + "selected the dimensions you wish to see.");
        alert.showAndWait();
    }
    
    @FXML
    private void handleOriginal(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        Color lightColor = Color.RED;
        Color darkColor = Color.BLACK;
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
        anchorPane = board.build();
        
        vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handleColor(ActionEvent event){
        vBox.getChildren().remove(anchorPane);
        Color lightColor = Color.SKYBLUE;
        Color darkColor = Color.DARKBLUE;
        CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
        anchorPane = board.build();
        
        vBox.getChildren().add(anchorPane);
    }
}
    

    

