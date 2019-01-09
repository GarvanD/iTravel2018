package iTravel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class LOB_Executive extends User {

    private final IntegerProperty conFirmedReservations;
    private final BooleanProperty statusOfFlight;

    public LOB_Executive(int confirmRes, Boolean fStatus, int iD, int pWord) {
        this.conFirmedReservations = new SimpleIntegerProperty(confirmRes);
        this.statusOfFlight = new SimpleBooleanProperty(fStatus);
        super.setiD(iD);
        super.setPassword(pWord);
    }


    public void setConFirmedReservations(int cR) {
        conFirmedReservations.set(cR);
    }
    public IntegerProperty confirmedReservationsProperty() {
        return conFirmedReservations;
    }
    public int getConfirmedReservations() {
        return conFirmedReservations.get();
    }

    public void setTotalFare(Boolean stat) {
        statusOfFlight.set(stat);
    }
    public BooleanProperty totalFareProperty() {
        return statusOfFlight;
    }
    public Boolean getStatusOfFlight() {
        return statusOfFlight.get();
    }

}

