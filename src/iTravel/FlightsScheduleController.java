package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class FlightsScheduleController implements Initializable {

    //TABLE VIEW AND DATA
    private FlightsAdapter flightsAdapter;
 
    @FXML
    private TableView<Flights> tableView;
    @FXML
    private TableColumn<Flights, Integer> flightNumberCol;
    @FXML
    private TableColumn<Flights, String> originCol;
    @FXML
    private TableColumn<Flights, String> destinationCol;
    @FXML
    private TableColumn<Flights, Integer> busSeatsCol;
    @FXML
    private TableColumn<Flights, Integer> execSeatsCol;

    final ObservableList<Flights> data = FXCollections.observableArrayList();
    
    public void setModel(FlightsAdapter flights) {

        flightsAdapter = flights;
        buildData();
    }

    public void buildData() {
        try {
            data.addAll(flightsAdapter.getFlightsList());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
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
    public void initialize(URL url, ResourceBundle rb) {
        flightNumberCol.setCellValueFactory(cellData -> cellData.getValue().flightNumberProperty().asObject());
        originCol.setCellValueFactory(cellData -> cellData.getValue().originProperty());
        destinationCol.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
        busSeatsCol.setCellValueFactory(cellData -> cellData.getValue().busSeatsProperty().asObject());
        execSeatsCol.setCellValueFactory(cellData -> cellData.getValue().execSeatsProperty().asObject());
        
        tableView.setItems(data);
    }    
    
}
