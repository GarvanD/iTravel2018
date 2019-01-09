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
public class FlightsAdapter {

    Connection connection;

    public FlightsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE Flights");
            } catch (SQLException ex) {
            } finally {
                stmt.execute("CREATE TABLE Flights ("
                        + "flightNumber INT NOT NULL PRIMARY KEY, "
                        + "origin CHAR(15), "
                        + "destination CHAR(15), "
                        + "busSeats INT, "
                        + "execSeats INT, "
                        + "busFare DOUBLE, "
                        + "execFare DOUBLE, "
                        + "totalReservation INT, "
                        + "flightTime CHAR(15), "
                        + "aircraftType CHAR(15), "
                        + "flightRevenue DOUBLE "
                        + ")");
                populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException {
       //Initial flights go here
    }


    public int getMax() throws SQLException {
        int num = 0;

        //
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(flightNumber) FROM Flights";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if (result.next()) {
            num = result.getInt(1);
        }


        return num;
    }

    public ObservableList<Integer> getFlightNumbers() throws SQLException {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String SQL = "SELECT flightNumber FROM Flights";
        rs = stmt.executeQuery(SQL);
        while(rs.next())
        {
            list.add(rs.getInt("flightNumber"));
        }

        return list;
    }


    public void insertFlight(int num, String origin, String destination, int busSeats, int execSeats, double busFare, double execFare, int totalReservation, String flightTime, String aircraftType, double flightRevenue) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Flights (flightNumber, origin, destination, busSeats, execSeats, busFare, execFare, totalReservation, flightTime, aircraftType, flightRevenue) "
                + "VALUES (" + num + " , '" + origin + "' , '" + destination + "', " + busSeats + ", " + execSeats + ", " + busFare + ", " + execFare + ", " + totalReservation + ", '" + flightTime + "', '" + aircraftType + "', " + flightRevenue + ")");
    }

    public void deleteFlight(int flightNum)
    {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM Flights WHERE flightNumber = " + flightNum + "");
        }
        catch (SQLException ex)
        {

        }

    }


    public ObservableList<Flights> getFlightsList() throws SQLException {
        ObservableList<Flights> flightsList = FXCollections.observableArrayList();


        //
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Flights";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next()) {
            flightsList.add(new Flights(result.getInt("flightNumber"),
                    result.getString("origin"),
                    result.getString("destination"),
                    result.getInt("busSeats"),
                    result.getInt("execSeats")));
        }

        return flightsList;
    }


    public ObservableList<String> getFlightsNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Flights";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next()) {
            list.add(new String(result.getInt("flightNumber") +
                    "-" + result.getString("origin") + " -" +
                    result.getString("destination")));
        }
        return list;
    }

}
    
