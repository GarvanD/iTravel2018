package iTravel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */

public class Reservation {

    private final IntegerProperty resNum;
    private final IntegerProperty flightNum;
    private final StringProperty seatClass;
    private final StringProperty resDate;
    private final BooleanProperty isUser;
    private final BooleanProperty isDiscount;
    private final IntegerProperty numTickets;

    public Reservation(int resNum, int fNum, String sC, String rDate, int ticket) {this(resNum, fNum, sC, rDate, false, false, ticket);}


    public Reservation(int resNum, int fNum, String sC, String rDate, Boolean user, Boolean discount, int ticket) {
        this.resNum = new SimpleIntegerProperty(resNum);
        this.flightNum = new SimpleIntegerProperty(fNum);
        this.seatClass = new SimpleStringProperty(sC);
        this.resDate = new SimpleStringProperty(rDate);
        this.isUser = new SimpleBooleanProperty(user);
        this.isDiscount = new SimpleBooleanProperty(discount);
        this.numTickets = new SimpleIntegerProperty(ticket);
    }


    public void setSeatClass(String sc) {
        seatClass.set(sc);
    }
    public StringProperty seatClassProperty() {
        return seatClass;
    }
    public String getSeatClass() {
        return seatClass.get();
    }
    
    public void setResDate(String dt) {
        resDate.set(dt);
    }
    public StringProperty resDateProperty() {
        return resDate;
    }
    public String getResDate() {
        return resDate.get();
    }
    
    public void setResNum(int rn) {
        resNum.set(rn);
    }
    public IntegerProperty resNumProperty() {
        return resNum;
    }
    public int getResNum() {
        return resNum.get();
    }

    public void setFlightNum(int f) {
        flightNum.set(f);
    }
    public IntegerProperty flightNumProperty() {
        return flightNum;
    }
    public int getFlightNum() {
        return flightNum.get();
    }

    public void setNumTickets(int t) {
        numTickets.set(t);
    }
    public IntegerProperty numTicketsProperty() {
        return numTickets;
    }
    public int getNumTickets() {
        return numTickets.get();
    }

    public void setIsDiscount(Boolean d) {
        isDiscount.set(d);
    }
    public BooleanProperty isDiscountProperty() {
        return isDiscount;
    }
    public Boolean getIsDiscount() {
        return isDiscount.get();
    }

    public void setIsUser(Boolean u) {
        isUser.set(u);
    }
    public BooleanProperty isUserProperty() {
        return isUser;
    }
    public Boolean getIsUser() {
        return isUser.get();
    }

}

