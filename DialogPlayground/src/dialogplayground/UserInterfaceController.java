/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogplayground;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dale
 * http://code.makery.ch/blog/javafx-dialogs-official/
 * 
 * These dialogs require JDK 8u40 or newer.
 */
public class UserInterfaceController implements Initializable {

    private Stage stage;
    
    @FXML
    private TextField confirmationResultTextField;
    
    @FXML
    private TextField textInputResultTextField;
    
    @FXML
    private TextField choiceResultTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    public void ready(Stage stage) {
       this.stage = stage; 
    }
    
    @FXML
    private void handleAbout(Event event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Dialog Playground");
        alert.setContentText("This application was developed by Dale Musser for CS3330 at the University of Missouri.  This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        alert.showAndWait();
    }
    
    @FXML
    private void handleAboutFull(Event event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Dialog Playground");
        alert.setContentText("This application was developed by Dale Musser for CS3330 at the University of Missouri.");
        
        /*
        TextArea textArea = new TextArea("This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        */
        
        Text text = new Text("This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        text.setWrappingWidth(330.0);
        
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        //expContent.add(textArea, 0, 0);
        expContent.add(text, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
    
    @FXML
    private void handleWarning(ActionEvent event) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Warning!");
        alert.setContentText("This is a warning.  Something bad could happen!");
        alert.showAndWait();
    }
    
    @FXML
    private void handleError(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error!");
        alert.setContentText("An error occurred.  Something bad did happen!");
        alert.showAndWait();
    }
    
    @FXML
    private void handleException(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText("Could not find file blabla.txt!");

        Exception ex = new FileNotFoundException("Could not find file blabla.txt");

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
    @FXML
    private void handleConfirmation(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirmation!");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            confirmationResultTextField.setText("OK selected");
        } else {
            // ... user chose CANCEL or closed the dialog
            confirmationResultTextField.setText("Cancel selected or dialog closed");
        }
    }
    
    @FXML
    private void handleTextInput(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("Sally Smith");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Information Requested!");
        dialog.setContentText("Please enter your name:");

       
        
        Optional<String> result = dialog.showAndWait();
         // Traditional way to get the response value.
        /*
        if (result.isPresent()){
            textInputResultTextField.setText(result.get());
        }
        */

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> textInputResultTextField.setText(name));        
    }
    
    @FXML
    private void handleChoice(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Pizza");
        choices.add("Steak");
        choices.add("Sushi");
        choices.add("Vegitarian");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Pizza", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Make a Choice");
        dialog.setContentText("Choose your meal:");

        Optional<String> result = dialog.showAndWait();
        
        // Traditional way to get the response value.
        if (result.isPresent()){
            choiceResultTextField.setText(result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(meal -> choiceResultTextField.setText(meal));
    }
    
}
