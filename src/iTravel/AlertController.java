package iTravel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class AlertController implements Initializable {

    
    
    @FXML public Label error;
   
    public void setAlertText(String text) {
        // set text from another class
        error.setText(text);
    } 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
}
