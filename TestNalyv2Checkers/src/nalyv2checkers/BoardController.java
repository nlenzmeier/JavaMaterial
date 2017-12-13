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
    
   // private int numRows = 8;
   // private int numCols = 8;
    
    //private final double anchorPaneWidth = anchorPane.getWidth();
    //private final double anchorPaneHeight = anchorPane.getHeight();
    
    private double rectWidth;
    private double rectHeight;
    
    private Stage stage;
    private CheckerBoard board;
    
//    @FXML
//    private Menu boardMenu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
    }  
    
    public void ready(Stage stage){ 
        this.stage = stage;

        board = new CheckerBoard(8, 8, anchorPane.getWidth(), anchorPane.getHeight());
        board.setBoard(anchorPane);
        
        board.build();
        
        ChangeListener<Number> widthListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            board.setBoardWidth((double) newValue);
            board.build();

        };  
        anchorPane.widthProperty().addListener(widthListener); 
        
        ChangeListener<Number> heightListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            board.setBoardHeight((double)newValue);
            board.build();
        };  
        anchorPane.heightProperty().addListener(heightListener);       
//        
//        anchorPane = board.build();
    }
    

       
    @FXML
    private void handle16(ActionEvent event){
        //vBox.getChildren().remove(anchorPane);
      //  numCols = 16;
      //  numRows = 16;
        board.setNumCols(16);
        board.setNumRows(16);
        //CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        board.build();
        
        //vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle10(ActionEvent event){
       // vBox.getChildren().remove(anchorPane);
        board.setNumCols(10);
        board.setNumRows(10);
        //render();
      //  CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        board.build();
        
        //vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle8(ActionEvent event){
        //vBox.getChildren().remove(anchorPane);
        board.setNumCols(8);
        board.setNumRows(8);
        //render();
        //CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        board.build();
        
        //vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handle3(ActionEvent event){
       // vBox.getChildren().remove(anchorPane);
        board.setNumCols(3);
        board.setNumRows(3);
        //render();
        //CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        board.build();
        
       // vBox.getChildren().add(anchorPane);
    }
    
    
     @FXML
    private void handleRefresh(ActionEvent event) {   
        //render();
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
      //  vBox.getChildren().remove(anchorPane);
      board.setLightColor(Color.RED);
      board.setDarkColor(Color.BLACK);
       // CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
         board.build();
        
     //   vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handleColor(ActionEvent event){
     //   vBox.getChildren().remove(anchorPane);
      board.setLightColor(Color.SKYBLUE);
      board.setDarkColor(Color.DARKBLUE);

       // CheckerBoard board = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
         board.build();
        
      //  vBox.getChildren().add(anchorPane);
    }
}
    

    

