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
public class TicketAdapter {

    Connection connection;

    public TicketAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Tickets");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Tickets ("
                        + "resNum INT NOT NULL PRIMARY KEY, "
                        + "ticketNum INT, "
                        + "fare DOUBLE, "
                        + "discount DOUBLE, "
                        + "seatClass CHAR(15) , "
                        + "ticketStatus INT, "
                        + "isRefund INT, "
                        + "refund DOUBLE "
                        + ")");
                //populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
        this.insertTicket(1,1,100,20,"Business",true,false,80);
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT MAX(ticketNum) FROM Tickets";
        ResultSet result = stmt.executeQuery(sqlStatement);
        if(result.next()){
            num = result.getInt(2);
        }

        
        return num;
    }
    
    public void insertTicket(int resN, int tickN, double f, double disc, String sC, Boolean tickS, Boolean isR, int refund) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Reservations (resNum, ticketNum, fare, discount, seatClass, ticketStatus, isRefund, refund) "
                + "VALUES (" + resN + " , " + tickN + " , " + f + " , " + disc + " , '" + sC + "' , " + tickS + " , " + isR + " , "+ refund + ")");
    }
    

    public ObservableList<Ticket> getTicketList() throws SQLException {
        ObservableList<Ticket> tickList = FXCollections.observableArrayList();


        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Tickets";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            tickList.add(new Ticket(result.getInt("resNum"),
                    result.getInt("ticketNum"),
                    result.getDouble("fare"),
                    result.getDouble("discount"),
                    result.getString("seatClass")));
        }

        
        return tickList;
    }


    public ObservableList<String> getTicketListBasic() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM Tickets";
        ResultSet result = stmt.executeQuery(sqlStatement);
        while (result.next())
        {
            list.add(new String(result.getInt("resNum")+
                    " - "+result.getInt("ticketNum")));
        }
        
        return list;
    }
}
