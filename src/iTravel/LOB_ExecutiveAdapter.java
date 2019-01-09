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
public class LOB_ExecutiveAdapter {

    Connection connection;

    public LOB_ExecutiveAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE LOBExecs");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE LOBExecs ("
                        + "iD INT NOT NULL PRIMARY KEY, "
                        + "confirmedReservations INT, "
                        + "statusOfFlight INT "
                        + ")");
                populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
        //Initial LOB goes here
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(iD) FROM LOBExecs";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(1);
        }

        return num;
    }
    
    public void insertLOBExec(int ID, int confirmedRes, Boolean status, int pWord) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO LOBExecs (iD, confirmedReservations, statusOfFlight) "
                + "VALUES (" + ID + " , " + confirmedRes + " , " + status + ")");
        stmt.executeUpdate("INSERT INTO Users (iD, password) "
                + "VALUES (" + ID + " , " + pWord + ")");
    }
    

    public ObservableList<LOB_Executive> getLOBlist() throws SQLException {
        ObservableList<LOB_Executive> lobList = FXCollections.observableArrayList();


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM LOBExecs";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            lobList.add(new LOB_Executive(result.getInt("confirmedReservations"),
                    result.getBoolean("statusOfFlight"),result.getInt("iD"),0));
        }

        return lobList;
    }
}
