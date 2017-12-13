/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2checkers;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Nicolle
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectWidth;
    private double rectHeight;
    private AnchorPane anchorPane;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public void build(){
        
        //anchorPane = new AnchorPane();
        
        //System.out.println("Build: ("+boardWidth+", "+boardHeight+")");
        //anchorPane.setMinWidth(boardWidth);
        //anchorPane.setMinHeight(boardHeight);
        //anchorPane.setMaxWidth(Double.MAX_VALUE);
        //anchorPane.setMaxHeight(Double.MAX_VALUE);
//        if (anchorPane.getChildren() != null) {
            anchorPane.getChildren().clear();
  //      }
        
        rectWidth = Math.ceil(boardWidth / numCols);
        rectHeight = Math.ceil(boardHeight / numRows);
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle r1 = new Rectangle(rectWidth, rectHeight);
                
                
                //Fills in rectangles
                if(row%2 == 0){     
                    if(col%2 == 0){    
                        r1.setFill(lightColor);
                    }

                    else{                   
                        r1.setFill(darkColor);
                    }                
                }
                
                else{
                    if(col%2 == 0){
                        r1.setFill(darkColor);
                    }
                    else{
                        r1.setFill(lightColor);
                    }
                }
                
                anchorPane.getChildren().addAll(r1);
                AnchorPane.setTopAnchor(r1, row*rectHeight);
                AnchorPane.setLeftAnchor(r1, col*rectWidth);
                
            }
        }
        
     //   return anchorPane;
    }
    
    public double getRectangleHeight(){
        return this.rectHeight;
    }
    
    public double getRectangleWidth(){
        return this.rectWidth;
    }
    
    public AnchorPane getBoard(){
        return this.anchorPane;
    }
    
    public void setBoard(AnchorPane newAnchorPane) {
        this.anchorPane = newAnchorPane;
    }
    
    public int getNumRows(){
        return this.numRows;
    }
    
    public void setNumRows(int newNumRows){
        this.numRows = newNumRows;
    }
    
    public int getNumCols(){
        return this.numCols;
    }
    
    public void setNumCols(int newNumCols){
        this.numCols = newNumCols;
    }
    
    public double getBoardWidth(){
        return this.boardWidth;
    }
    
    public void setBoardWidth(double newBoardWidth){
        this.boardWidth = newBoardWidth;
    }
    
    public void setBoardHeight(double newBoardHeight){
        this.boardHeight = newBoardHeight;
    }
    
    public double getBoardHeight(){
        return this.boardHeight;
    }
    
    public Color getLightColor(){
        return this.lightColor;
    }
    
    public void setLightColor(Color newLightColor){
        this.lightColor = newLightColor;
    }
    
    public Color getDarkColor(){
        return this.darkColor;
    }
    
    public void setDarkColor(Color newDarkColor){
        this.darkColor = newDarkColor;
    }
}