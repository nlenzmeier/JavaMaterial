/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2stopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nicolle
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private ImageView hand;
    @FXML
    private Label label;
    Timeline timeLine;
    Integer ms = 0, seconds = 0, minutes = 0; 
    @FXML
    Label digital = new Label();
    Double rotation = 0.0;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    } 
    
    @FXML
    private void handleStartButtonAction (ActionEvent event) {
        System.out.println("Start");
        label.setText("Start");
        
        timeLine.play();
    }
    
    @FXML
    private void handleResetButtonAction (ActionEvent event) {
        System.out.println("Reset");
        label.setText("Reset");
        
        resetStopwatch();
    }
    
    @FXML
    private void handleStopButtonAction (ActionEvent event) {
        System.out.println("Stop");
        label.setText("Stop"); 
        
        timeLine.pause();
    }
    
    public void updateStopwatch() {
        ms += 1000;
        if(ms >= 60000)
            ms = 0;
    
        rotation = (ms / 60000.0) * 360.0;
        hand.setRotate(rotation);
        
        seconds++;
        if(seconds > 59){
            minutes++;
            seconds = 0;
        } 
        if(minutes < 1 && seconds < 10){
            digital.setText("00:0" + seconds.toString());
            //digital.setStyle("-fx-font-size: 6em;");
        }
        else if(minutes < 10 && seconds < 10){
            digital.setText("0" + minutes.toString() + ":0" + seconds.toString());
            //digital.setStyle("-fx-font-size: 6em;");  
        }
        else if(minutes < 10 && seconds >= 10){
            digital.setText("0" + minutes.toString() + ":" + seconds.toString());
            //digital.setStyle("-fx-font-size: 6em;");  
        }
        else{
            digital.setText(minutes.toString() + ":" + seconds.toString());
            //digital.setStyle("-fx-font-size: 6em;");  
        }
        
    }
    
    public void resetStopwatch(){
        timeLine.stop();
        ms = 0;
        
        hand.setRotate(ms);
        minutes = 0;
        seconds = 0;
        digital.setText(minutes.toString() + "0:0" + seconds.toString());
        //digital.setStyle("-fx-font-size: 6em;");
    }
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeLine = new Timeline(
                    new KeyFrame(Duration.millis(1000), actionEvent -> {
                        updateStopwatch();
                    })
            ); 
        
        timeLine.setCycleCount(Animation.INDEFINITE);
        //timeLine.play();
    } 

}
    
    

