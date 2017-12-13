/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2saxparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserFactory;

/**
 * FXML Controller class
 *
 * @author Nicolle
 */
public class ParserViewController implements Initializable {

    @FXML
    private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleOpen(ActionEvent event) throws SAXException, ParserConfigurationException {
        
          SAXParserFactory factory = SAXParserFactory.newInstance();
        // create a new DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
            // define what the parser does when it finds a character
            public void characters(char[] ch, int start, int length) {
            // print the characters
            System.out.println("" + new String(ch, start, length));
            }
        };

      try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());            
            // create a new inputstream for our XML
            FileInputStream is = new FileInputStream(file);
            // get a new SAXParser
            SAXParser parser = factory.newSAXParser();
            // parse the file
            parser.parse(is, new SaxHandler());          
            System.out.println("FROM THE FILE: " + file);
            
            //System.out.println("\n\n----- DOM STUFF -----\n\n");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
      
      //Figured that I needed a hashmap and to fully create the DOM, but I am getting
      //stuck on that part. I am sorry. 
      
      
      //practice with hashmaps. 
      //new java class was made, but deleted for submission purposes. 
//      HashMap<String, String> person = new HashMap<>();
//    person.put("firstname", "Jane");
//    person.put("lastname", "Doe");
//    System.out.println("Person: " + person);
      
    } 
    
    @FXML
    private void handleAbout(ActionEvent event) {
        displayAboutAlert();
    }
    
    private void displayAboutAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("XML DOM Parser Example");
        alert.setContentText("This application was developed by Dale Musser for CS4330 at the University of Missouri.");
        
        TextArea textArea = new TextArea("This example illustrates how to parse XML using the DOM.");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
    /*
    private void displayExceptionAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);

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
    }*/
}
