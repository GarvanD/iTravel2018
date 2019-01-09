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
public class UserAdapter {

    Connection connection;

    public UserAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Users");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Users ("
                        + "iD INT NOT NULL PRIMARY KEY, "
                        + "password INT "
                        + ")");
                //populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
        this.insertUser(2,333);
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(iD) FROM Users";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(1);
        }

        return num;
    }
    
    public void insertUser(int ID, int pWord) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Users (iD, password) "
                + "VALUES (" + ID + " , " + pWord + ")");
    }
    

    public ObservableList<User> getUserList() throws SQLException {
        ObservableList<User> userList = FXCollections.observableArrayList();


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Users";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            userList.add(new Customer(result.getInt("customerID"),
                    result.getString("customerName"),
                    result.getString("commonDestination"),
                    result.getString("commonSeatClass"),
                    result.getInt("numberOfFlights")));
        }

        return userList;
    }


    public ObservableList<Integer> getUserIDList() throws SQLException {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Users";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            list.add(new Integer(result.getInt("iD")));
        }
        
        return list;
    }
}
