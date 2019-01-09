package iTravel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */

public class AddEmployeeController implements Initializable {

    @FXML
    Button saveBtn;

    @FXML
    Button cancelBtn;

    private EmployeeAdapter employee;


    @FXML
    TextField  name, flightsCreated, email, pword;

    public void setModel(EmployeeAdapter em){employee = em;}

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save()
    {
        try {
            employee.insertEmployee(employee.getMax()+1, name.getText(),Integer.parseInt(flightsCreated.getText().toString()),email.getText().toString(),pword.getText().toString());

        }catch(SQLException ex)
        {
            displayAlert("ERROR: " + ex.getMessage());
        }
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


