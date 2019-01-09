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
public class ReservationAdapter {

    Connection connection;

    public ReservationAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Reservations");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Reservations ("
                        + "resNum INT NOT NULL PRIMARY KEY, "
                        + "flightNum INT, "
                        + "seatClass CHAR(15) , "
                        + "resDate CHAR(15), "
                        + "isUser INT, "
                        + "isDiscount INT, "
                        + "numTickets INT "
                        + ")");
                //populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
        this.insertReservation(1,1,"Business","Monday, Oct 15, 2016",true,true,1);
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(resNum) FROM Reservations";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(1);
        }

        
        return num;
    }
    
    public void insertReservation(int resN, int flightN, String sC, String rD, Boolean isU, Boolean isD, int tickets) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Reservations (resNum, flightNum, seatClass, resDate, isUser, isDiscount, numTickets) "
                + "VALUES (" + resN + " , " + flightN + " , '" + sC + "', '" + rD + "' , " + isU + ", " + isD + ", " + tickets + ")");
    }
    

    public ObservableList<Reservation> getReservationList() throws SQLException {
        ObservableList<Reservation> resList = FXCollections.observableArrayList();


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Reservations";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            resList.add(new Reservation(result.getInt("resNum"),
                    result.getInt("flightNum"),
                    result.getString("seatClass"),
                    result.getString("resDate"),
                    result.getInt("numTickets")));
        }

        
        return resList;
    }


    public ObservableList<String> getReservationListBasic() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Reservations";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            list.add(new String(result.getInt("resNum")+
                    " - "+result.getInt("flightNum")));
        }
        
        return list;
    }
}
