/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */


public class MainController implements Initializable {

    private Connection conn;
    private FlightsAdapter flights;
    private EmployeeAdapter employees;
    private UserAdapter users;
    private LOB_ExecutiveAdapter lob;
    private CustomerAdapter customers;
    private ReservationAdapter reservations;
    private TicketAdapter tickets;

    @FXML
    private MenuBar mainMenu;

    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    @FXML
    public void resetDB() {
        try {
            flights = new FlightsAdapter(conn, true);
            displayAlert("Flights table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        try {
            employees = new EmployeeAdapter(conn, true);
            displayAlert("Employees table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        try {
            users = new UserAdapter(conn, true);
            displayAlert("Users table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        try {
            lob = new LOB_ExecutiveAdapter(conn, true);
            displayAlert("LOB Executive table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        try {
            customers = new CustomerAdapter(conn, true);
            displayAlert("Customers table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        try {
            reservations = new ReservationAdapter(conn, true);
            displayAlert("Reservations table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        try {
            tickets = new TicketAdapter(conn, true);
            displayAlert("Tickets table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }



    public void showFlights() throws Exception {

        flights = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("flightsSchedule.fxml"));
        Parent flightsList = (Parent) fxmlLoader.load();

        FlightsScheduleController flightschedulecontroller = (FlightsScheduleController) fxmlLoader.getController();
        flightschedulecontroller.setModel(flights);

        Scene scene = new Scene(flightsList);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Flights");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void addEmployee() throws Exception {
        employees = new EmployeeAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddEmployee.fxml"));
        Parent AddEmployee = fxmlLoader.load();

        AddEmployeeController addEmpC = fxmlLoader.getController();
        addEmpC.setModel(employees);

        Scene scene = new Scene(AddEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Add Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void addFlights() throws Exception {
        flights = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddFlight.fxml"));
        Parent addFlight = fxmlLoader.load();

        AddFlightController addFlightC = fxmlLoader.getController();
        addFlightC.setModel(flights);

        Scene scene = new Scene(addFlight);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Add Flight");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    public void removeFlights() throws Exception {
        flights = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveFlight.fxml"));
        Parent RemoveFlight = fxmlLoader.load();

        RemoveFlightController removeFlightC = fxmlLoader.getController();
        removeFlightC.setModel(flights);

        Scene scene = new Scene(RemoveFlight);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Remove Flight");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void removeEmployee() throws Exception {
        employees = new EmployeeAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveEmployee.fxml"));
        Parent RemoveEmployee = fxmlLoader.load();

        RemoveEmployeeController removeEmpC = fxmlLoader.getController();
        removeEmpC.setModel(employees);

        Scene scene = new Scene(RemoveEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Remove Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    public void editEmployee() throws Exception {
        employees = new EmployeeAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditEmployee.fxml"));
        Parent EditEmployee = fxmlLoader.load();

        EditEmployeeController editEmpC = fxmlLoader.getController();
        editEmpC.setModel(employees);

        Scene scene = new Scene(EditEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Edit Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:TeamDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {
            displayAlert(ex.getMessage());
        }

    }

    public void showEmployees() throws Exception {

        employees = new EmployeeAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeeList.fxml"));
        Parent employeeList = (Parent) fxmlLoader.load();

        EmployeeListController employeelistcont = (EmployeeListController) fxmlLoader.getController();
        employeelistcont.setModel(employees);

        Scene scene = new Scene(employeeList);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
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
}

