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

public class AddFlightController implements Initializable {

    @FXML
    Button saveBtn;

    @FXML
    Button cancelBtn;

    private FlightsAdapter flight;


    @FXML
    TextField dest, origin, seatsbc, seatsec, flightime, typeofaircraft;

    public void setModel(FlightsAdapter fa){flight = fa;}

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save()
    {
        try {
            int seatsBC = Integer.parseInt(seatsbc.getText());
            int seatsEC = Integer.parseInt(seatsec.getText());
            int totalRes = seatsBC + seatsEC;
            double busFare = 300 * seatsBC;
            double execFare = 300 * seatsEC;
            double flightRev = busFare + execFare;
            flight.insertFlight(flight.getMax()+1, (String)origin.getText(), (String)dest.getText(), (int)seatsBC, (int)seatsEC, (double)busFare, (double)execFare, (int)totalRes, flightime.getText(), typeofaircraft.getText(), (double)flightRev);
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


