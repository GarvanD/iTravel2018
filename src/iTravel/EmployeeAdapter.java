package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */

public class EmployeeAdapter {

    Connection connection;

    public EmployeeAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Employees");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Employees ("
                        + "employeeID INT NOT NULL PRIMARY KEY, "
                        + "emName CHAR(15), "
                        + "flightsCreated INT, "
                        + "employeeEmail CHAR(15), "
                        + "password CHAR(15) "
                        + ")");
                //populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException{
            // Create a listing of initial employees
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;

        //
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(employeeID) FROM Employees";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(1);
        }

        return num;
    }
    
    public void insertEmployee(int id, String nm, int fc, String mail, String pword) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Employees (employeeID, emName, flightsCreated, employeeEmail, password) "
                + "VALUES (" + id + " , '" + nm + "' , " + fc + ", '" + mail + "', '" + pword + "')");
    }


    public void editEmployee(int idNum, String name, int flightsCreated, String email, String Password)
    {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE Employees SET emName = '" + name + "' WHERE employeeID = " + idNum + " ");
            stmt.executeUpdate("UPDATE Employees SET flightsCreated = " + flightsCreated + " WHERE employeeID = " + idNum + " ");
            stmt.executeUpdate("UPDATE Employees SET employeeEmail = '" + email + "' WHERE employeeID = " + idNum + " ");
            stmt.executeUpdate("UPDATE Employees SET password = '" + Password + "' WHERE employeeID = " + idNum + " ");
        }catch (SQLException ex)
        {

        }
    }

    

    public ObservableList<Employee> getEmployeesList() throws SQLException {
        ObservableList<Employee> employeesList = FXCollections.observableArrayList();

        //
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Employees";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            employeesList.add(new Employee(result.getInt("employeeID"),
                    result.getString("emName"),
                    result.getInt("flightsCreated"),
                    result.getString("employeeEmail"),
                    result.getString("password")));
        }
        
        return employeesList;
    }

    public ObservableList<Integer> getEmployeeNumbers() throws SQLException {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String SQL = "SELECT employeeID FROM Employees";
        rs = stmt.executeQuery(SQL);

        while(rs.next())
        {
            list.add(rs.getInt("employeeID"));
        }

        return list;
    }


    public void deleteEmployee(int ID)
    {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM Employees WHERE employeeID = " + ID + "");
        }
        catch (SQLException ex)
        {

        }

    }



    public ObservableList<String> getEmployeeNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Flights";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            list.add(new String(result.getInt("flightNumber")+
                    "-"+result.getString("origin")+ " -" +
                    result.getString("destination")));
        }

        
        return list;
    }
    

}
