/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Nicolle
 */
public class Nalyv2Visualizer3 implements Visualizer {
    private final String name = "Piano Visualizer";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
    private String vizPaneInitialStyle = "";
    
    private final Double bandHeightPercentage = 1.3;
    private final Double minEllipseRadius = 10.0;  // 10.0
    private final Double rotatePhaseMultiplier = 300.0;
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private Double halfBandHeight = 0.0;
    private Double halfBandWidth = 0.0;
    
    private final Double startHue = 100.0;
   
    
    private Rectangle[] rectangles;
    
    public Nalyv2Visualizer3() {
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {        
        end();
        
        vizPaneInitialStyle = vizPane.getStyle();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        Rectangle clip = new Rectangle(width, height);
        clip.setLayoutX(0);
        clip.setLayoutY(0);
        vizPane.setClip(clip);
        
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        rectangles = new Rectangle[numBands];
        halfBandWidth = bandWidth / 2;
        
        
        for (int i = 0; i < numBands; i++) {
            Rectangle rec = new Rectangle();
            double centerX = halfBandWidth + bandWidth * i;
            double centerY = height / 2;
            rec.setX(centerX - halfBandWidth);
            rec.setY(centerY - height / 2);
            rec.setWidth(bandWidth);
            rec.setHeight(minEllipseRadius);
            //rec.setFill(Color.grayRgb(100));
            rec.setFill(Color.hsb(startHue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(rec);
            rectangles[i] = rec;
        }
    }
    
    @Override
    public void end() {
        if (rectangles != null) {
            for (Rectangle rec : rectangles) {
                vizPane.getChildren().remove(rec);
            }
            rectangles = null;
            vizPane.setClip(null);
            vizPane.setStyle(vizPaneInitialStyle);
        }        
    }

    
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (rectangles == null) {
            return;
        }
        
        Integer num = min(rectangles.length, magnitudes.length);
        
        for (int i = 0; i < num; i++) {
            rectangles[i].setHeight(((60.0 + magnitudes[i])/60.0) * halfBandHeight + minEllipseRadius);
            rectangles[i].setFill(Color.hsb(startHue - (magnitudes[i] * -6.0), 1.0, 1.0, 1.0));
            rectangles[i].setRotate(phases[i]);
            if(i%2 == 0){
                rectangles[i].setFill(Color.grayRgb(255));
            }
            if(i%2 == 1){
                rectangles[i].setFill(Color.grayRgb(0));
            }
            //rectangles[i].setFill(Color.rgb(0, 0, 0, 100));
        }
        Double hue = ((60.0 + magnitudes[0])/60.0) * 360;
        vizPane.setStyle("-fx-background-color: hsb(" + hue + ", 0%, 0%)" );
    }  
}

