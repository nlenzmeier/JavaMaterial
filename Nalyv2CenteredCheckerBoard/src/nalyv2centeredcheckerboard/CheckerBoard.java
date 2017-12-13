/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2centeredcheckerboard;

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
    //private double leftover;
    //private double halfLeft;
    
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
    
    public void buildRect(AnchorPane anchorPane, double x, double y, double width, double height, Color color){
        Rectangle r1 = new Rectangle(width, height);
        anchorPane.getChildren().addAll(r1);
        AnchorPane.setTopAnchor(r1, y);
        AnchorPane.setLeftAnchor(r1, x);
        r1.setFill(color);
    }
    
    
//    public AnchorPane build4(){
//        anchorPane = new AnchorPane();
//        
//        anchorPane.setMinWidth(boardWidth);
//        anchorPane.setMinHeight(boardHeight);
//        
//        buildRect(anchorPane, 20, 15, 20, 15, Color.RED);
//        buildRect(anchorPane, 15, 20, 50, 10, Color.BLUE);
//        buildRect(anchorPane, 18, 30, 100, 20, Color.GREEN);
////        Rectangle r1 = new Rectangle(40, 65);
////        anchorPane.getChildren().addAll(r1);
////        AnchorPane.setTopAnchor(r1, 20.0);
////        AnchorPane.setLeftAnchor(r1, 15.0);
////        r1.setFill(Color.RED);
//        
////        Rectangle r2 = new Rectangle(15, 20);
////        anchorPane.getChildren().addAll(r2);
////        AnchorPane.setTopAnchor(r2, 10.0);
////        AnchorPane.setLeftAnchor(r2, 50.0);
////        r2.setFill(Color.BLUE);
////        
////        Rectangle r3 = new Rectangle(18, 30);
////        anchorPane.getChildren().addAll(r3);
////        AnchorPane.setTopAnchor(r3, 20.0);
////        AnchorPane.setLeftAnchor(r3, 100.0);
//        //r3.setFill(Color.GREEN);
//        
//        return anchorPane;
//    }
    
    
//    public AnchorPane build3(){
//        
//        anchorPane = new AnchorPane();
//        
//        anchorPane.setMinWidth(boardWidth);
//        anchorPane.setMinHeight(boardHeight);
//        
//        rectWidth = Math.ceil(boardWidth / numCols);
//        rectHeight = Math.ceil(boardHeight / numRows);
//       
//        //double leftover = 0;
//        double halfLeft = 0;    
//        double halfTop = 0;
//        
//        
//        if(rectWidth > rectHeight){
//            rectWidth = rectHeight;
//            double leftover = boardWidth - rectWidth*numCols;
//            halfLeft = leftover/2;
//        }
//        
//        if(rectHeight > rectWidth){
//            rectHeight = rectWidth;
//            double leftover = boardHeight - rectHeight*numRows;
//            halfTop = leftover/2;
//
//        }
//        
//        //halfLeft = leftover/2;
//        
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                Rectangle r1 = new Rectangle(rectWidth, rectHeight);                               
//                //Fills in rectangles         
//                if(row%2 == 0){     
//                    if(col%2 == 0){    
//                        r1.setFill(lightColor);
//                    }
//                    else{                   
//                        r1.setFill(darkColor);
//                    }                
//                }                
//                else{
//                    if(col%2 == 0){
//                        r1.setFill(darkColor);
//                    }
//                    else{
//                        r1.setFill(lightColor);
//                    }
//                }  
//                
////                if(rectWidth > rectHeight){
////                    anchorPane.getChildren().add(halfLeft);
////                    anchorPane.getChildren().addAll(r1);
////                    AnchorPane.setTopAnchor(r1, halfLeft);
////                    AnchorPane.setLeftAnchor(r1, halfLeft); 
////                }
//                //else{
//                    //original code for the AnchorPane
//                    anchorPane.getChildren().addAll(r1);
//                    AnchorPane.setTopAnchor(r1, row*rectHeight);
//                    AnchorPane.setLeftAnchor(r1, col*rectWidth);
//                //}
//            }
//        }
//        
//        return anchorPane;
//    }
    
    public AnchorPane build(){
        anchorPane = new AnchorPane();
        
        anchorPane.setMinWidth(boardWidth);
        anchorPane.setMinHeight(boardHeight);
        
        rectWidth = Math.ceil(boardWidth / numCols);
        rectHeight = Math.ceil(boardHeight / numRows);
        
        Color color;
        //double xOffset;
        
        
        if(rectWidth > rectHeight){
            rectWidth = rectHeight;
        }
        
        if(rectHeight > rectWidth){
            rectHeight = rectWidth;
        }
        
        double checkerBoardWidth = rectWidth*numCols;
        double xOffset = (boardWidth-checkerBoardWidth)/2;
        
        double checkerBoardHeight = rectHeight*numRows;
        double yOffset = (boardHeight-checkerBoardHeight)/2;
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {                                               
                //Fills in rectangles
                if(row%2 == 0){     
                    if(col%2 == 0){ 
                        color = lightColor;
                    }
                    else{  
                        color = darkColor;
                    }                
                }                
                else{
                    if(col%2 == 0){
                        color = darkColor;
                    }
                    else{
                        color = lightColor;
                    }
                }          
                buildRect(anchorPane, col*rectWidth + xOffset, row*rectHeight + yOffset, rectWidth, rectHeight, color);                
            }
        }        
        
        return anchorPane;
    }
    
//    public AnchorPane build2(){
//        
//        anchorPane = new AnchorPane();
//        
//        anchorPane.setMinWidth(boardWidth);
//        anchorPane.setMinHeight(boardHeight);
//        
//        rectWidth = Math.ceil(boardWidth / numCols);
//        rectHeight = Math.ceil(boardHeight / numRows);
//        
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                Rectangle r1 = new Rectangle(rectWidth, rectHeight);                               
//                //Fills in rectangles
//                if(row%2 == 0){     
//                    if(col%2 == 0){    
//                        r1.setFill(lightColor);
//                    }
//                    else{                   
//                        r1.setFill(darkColor);
//                    }                
//                }                
//                else{
//                    if(col%2 == 0){
//                        r1.setFill(darkColor);
//                    }
//                    else{
//                        r1.setFill(lightColor);
//                    }
//                }                
//                anchorPane.getChildren().addAll(r1);
//                AnchorPane.setTopAnchor(r1, row*rectHeight);
//                AnchorPane.setLeftAnchor(r1, col*rectWidth);                
//            }
//        }        
//        return anchorPane;
//    }
    
    public double getRectangleHeight(){
        return this.rectHeight;
    }
    
    public double getRectangleWidth(){
        return this.rectWidth;
    }
    
    public AnchorPane getBoard(){
        return this.anchorPane;
    }
    
    public int getNumRows(){
        return this.numRows;
    }
    
    public int getNumCols(){
        return this.numCols;
    }
    
    public double getBoardWidth(){
        return this.boardWidth;
    }
    
    public double getBoardHeight(){
        return this.boardHeight;
    }
    
    public Color getLightColor(){
        return this.lightColor;
    }
    
    public Color getDarkColor(){
        return this.darkColor;
    }
}