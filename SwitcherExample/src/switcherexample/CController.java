/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switcherexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author dale
 */
public class CController extends Switchable implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    @FXML
    private void handleGoToA(ActionEvent event) {
        Switchable.switchTo("A");
    }
    
    @FXML
    private void handleGoToB(ActionEvent event) {
        Switchable.switchTo("B");
    }
    
}
