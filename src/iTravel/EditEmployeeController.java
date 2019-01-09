package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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


public class EditEmployeeController implements Initializable {


    @FXML
    ComboBox employeeid;

    @FXML
    TextField email, name, flights, password;

    @FXML
    Button cancelBtn, save;



    private EmployeeAdapter employee;

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save()
    {
        employee.editEmployee(Integer.parseInt(employeeid.getValue().toString()), name.getText(),Integer.parseInt(flights.getText()), email.getText(), password.getText());


        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    final ObservableList<Integer> data = FXCollections.observableArrayList();

    public void buildComboBoxData() {
        try{
            if(data.isEmpty()){
                data.addAll(employee.getEmployeeNumbers());
            }

        }catch (SQLException ex)
        {
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

    public void setModel(EmployeeAdapter fa){
        employee = fa;
        buildComboBoxData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        employeeid.setItems(data);
    }
}
