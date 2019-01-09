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

public class CustomerAdapter {

    Connection connection;

    public CustomerAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Customers");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Customers ("
                        + "customerID INT NOT NULL PRIMARY KEY, "
                        + "customerName CHAR(15), "
                        + "commonDestination CHAR(15) , "
                        + "commonSeatClass CHAR(15), "
                        + "numberOfFlights INT, "
                        + "totalFare DOUBLE, "
                        + "paymentInfo INT, "
                        + "emailID CHAR(15) "
                        + ")");
                //populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
        this.insertCustomer(3,"Matt","Toronto","Business",3,300,123456,"matt@gmail.com",333);

    }
        
    
    public int getMax() throws SQLException {
        int num = 0;


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(customerID) FROM Customers";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(1);
        }

        return num;
    }
    
    public void insertCustomer(int cID, String nm, String destination, String sC, int numF, double tF, int pay, String email,int pWord) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Customers (customerID, customerName, commonDestination, commonSeatClass, numberOfFlights, totalFare, paymentInfo, emailID) "
                + "VALUES (" + cID + " , '" + nm + "' , '" + destination + "', '" + sC + "' , " + numF + ", " + tF + ", " + pay + ", '" + email + "')");
        stmt.executeUpdate("INSERT INTO Users (iD, password) "
                + "VALUES (" + cID + " , " + pWord + ")");
    }
    

    public ObservableList<Customer> getCustomerList() throws SQLException {
        ObservableList<Customer> custList = FXCollections.observableArrayList();


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Customers";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            custList.add(new Customer(result.getInt("customerID"),
                    result.getString("customerName"),
                    result.getString("commonDestination"),
                    result.getString("commonSeatClass"),
                    result.getInt("numberOfFlights")));
        }

        return custList;
    }


    public ObservableList<String> getCustomerNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Customers";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            list.add(new String(result.getInt("customerID")+
                    " - "+result.getString("customerName")));
        }
        
        return list;
    }
}
