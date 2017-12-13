/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2stopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nicolle
 */
public class Nalyv2Stopwatch extends Application {
    
    private ImageView hand;//imageview is a rectangle that holds an image 
    private final Integer elapsedTime = 0; // seconds
    Timeline timeLine;
    Double rotation = 0.0;
    Integer ms = 0, seconds = 0, minutes = 0; 
    Label digital = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        
        ImageView clockFace = new ImageView();
        Image clockFaceImage = new Image(this.getClass().getResourceAsStream("clockface.png"));
        clockFace.setImage(clockFaceImage);
        
        hand = new ImageView();
        Image handImage = new Image(this.getClass().getResourceAsStream("hand.png"));
        hand.setImage(handImage);
        
        StackPane root = new StackPane();
        
        Button start = new Button();
        start.setText("Start");      
        Button stop = new Button();
        stop.setText("Stop");
        Button reset = new Button();
        reset.setText("Reset");
        
        StackPane.setAlignment(start, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(stop, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(reset, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(digital, Pos.TOP_CENTER);
        
        root.getChildren().addAll(clockFace, hand, start, stop, reset, digital);
        
        Scene scene = new Scene(root, 325, 475);
        
        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
                
     
        
        timeLine = new Timeline(
                new KeyFrame(Duration.millis(1000), actionEvent -> {
                    updateStopwatch();
            })
        );
        start.setOnAction((ActionEvent event) -> {
            timeLine.play();
        });
        stop.setOnAction((ActionEvent event) -> {
            timeLine.pause();
        });
        reset.setOnAction((ActionEvent event) -> {
            resetStopwatch();
        });
        
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
    
    // this is how the animation can be stopped
    // timeLine.stop();
    
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
            digital.setStyle("-fx-font-size: 6em;");
        }
        else if(minutes < 10 && seconds < 10){
            digital.setText("0" + minutes.toString() + ":0" + seconds.toString());
            digital.setStyle("-fx-font-size: 6em;");  
        }
        else if(minutes < 10 && seconds >= 10){
            digital.setText("0" + minutes.toString() + ":" + seconds.toString());
            digital.setStyle("-fx-font-size: 6em;");  
        }
        else{
            digital.setText(minutes.toString() + ":" + seconds.toString());
            digital.setStyle("-fx-font-size: 6em;");  
        }
        
    }
    public void resetStopwatch(){
        timeLine.stop();
        ms = 0;
        
        hand.setRotate(ms);
        minutes = 0;
        seconds = 0;
        digital.setText(minutes.toString() + "0:0" + seconds.toString());
        digital.setStyle("-fx-font-size: 6em;");
    }
}

