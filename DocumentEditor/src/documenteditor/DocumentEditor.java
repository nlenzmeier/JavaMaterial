/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * @author dalemusser
 */
public class DocumentEditor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(20);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        
        TextArea editor = new TextArea();
        editor.setPrefRowCount(25);
        editor.setPrefColumnCount(45);
        
        //HTMLEditor editor = new HTMLEditor();
        //editor.setPrefSize(600, 500);
        
        Button saveButton = new Button("Save");
        HBox saveButtonBox = new HBox();
        saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
        saveButtonBox.getChildren().add(saveButton);
        
        //saveButton.setRotate(45);
        
        grid.add(titleFieldBox, 0, 0);
        grid.add(editor, 0, 1);
        grid.add(saveButtonBox, 0, 2);
        
        Scene scene = new Scene(root, 800, 700);
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        MenuItem openMenuItem = new MenuItem("Open");
        fileMenu.getItems().add(openMenuItem);
        
        openMenuItem.setOnAction((ActionEvent event) -> {
            System.out.println("Open chosen");
        });
        
        root.getChildren().add(menuBar);
        root.getChildren().add(grid);
        
        primaryStage.setTitle("Editor");
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
