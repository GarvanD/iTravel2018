package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class Employee {

    private final StringProperty emName;
    private final IntegerProperty  employeeID;
    private final IntegerProperty flightsCreated;
    private final StringProperty employeeEmail;
    private final StringProperty password;

    public Employee(int id, String name, int fc) {
        this(id, name, fc, "0","0");
    }

    public Employee(int id, String name, int flightscreated, String mail, String pword) {
        this.emName = new SimpleStringProperty(name);
        this.employeeID = new SimpleIntegerProperty(id);
        this.flightsCreated = new SimpleIntegerProperty(flightscreated);
        this.employeeEmail = new SimpleStringProperty(mail);
        this.password = new SimpleStringProperty(pword);
    }


    public void setEmName(String _name) {
        emName.set(_name);
    }
    public StringProperty emNameProperty() {
        return emName;
    }
    public String getEmName() {
        return emName.get();
    }
    
    public void setEmployeeID(int id) {
        employeeID.set(id);
    }
    public IntegerProperty employeeIDProperty() {
        return employeeID;
    }
    public int getEmployeeID() {
        return employeeID.get();
    }
    
    public void setFlightsCreated(int fc) {
        flightsCreated.set(fc);
    }
    public IntegerProperty flightsCreatedProperty() {
        return flightsCreated;
    }
    public int getFlightsCreated() {
        return flightsCreated.get();
    }

    public void setEmployeeEmail(String _name) {
        employeeEmail.set(_name);
    }
    public StringProperty employeeEmailProperty() {
        return employeeEmail;
    }
    public String getEmployeeEmail() {
        return employeeEmail.get();
    }

    public void setPassword(String _name) {
        password.set(_name);
    }
    public StringProperty passwordProperty() {
        return password;
    }
    public String getPassword() {
        return password.get();
    }

}
