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
public class EmployeeListController implements Initializable {

    //TABLE VIEW AND DATA
    private EmployeeAdapter employeeAdapter;
 
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, Integer> employeeIDCol;
    @FXML
    private TableColumn<Employee, String> employeeNameCol;
    @FXML
    private TableColumn<Employee, Integer> flightsCreatedCol;
    @FXML
    private TableColumn<Employee, String> employeeEmailCol;
    @FXML
    private TableColumn<Employee, String> passwordCol;

    final ObservableList<Employee> data = FXCollections.observableArrayList();
    
    public void setModel(EmployeeAdapter employee) {

        employeeAdapter = employee;
        buildData();
    }

    public void buildData() {
        try {
            data.addAll(employeeAdapter.getEmployeesList());
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
        employeeIDCol.setCellValueFactory(cellData -> cellData.getValue().employeeIDProperty().asObject());
        employeeNameCol.setCellValueFactory(cellData -> cellData.getValue().emNameProperty());
        flightsCreatedCol.setCellValueFactory(cellData -> cellData.getValue().flightsCreatedProperty().asObject());
        employeeEmailCol.setCellValueFactory(cellData -> cellData.getValue().employeeEmailProperty());
        passwordCol.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        
        tableView.setItems(data);
    }    
    
}
