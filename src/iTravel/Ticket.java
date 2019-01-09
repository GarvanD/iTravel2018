package iTravel;

import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class Ticket {

    private final IntegerProperty resNum;
    private final IntegerProperty ticketNum;
    private final DoubleProperty fare;
    private final DoubleProperty discount;
    private final StringProperty seatClass;
    private final BooleanProperty ticketStatus;
    private final BooleanProperty isRefund;
    private final DoubleProperty refund;

    public Ticket(int resNum, int tNum, double fare, double discount, String sC) {this(resNum, tNum, fare, discount, sC, false, false, 0);}


    public Ticket(int resNum, int tNum, double fare, double discount, String sC, Boolean tickStat, Boolean isRef, double ref) {
        this.resNum = new SimpleIntegerProperty(resNum);
        this.ticketNum = new SimpleIntegerProperty(tNum);
        this.seatClass = new SimpleStringProperty(sC);
        this.fare = new SimpleDoubleProperty(fare);
        this.discount = new SimpleDoubleProperty(discount);
        this.ticketStatus = new SimpleBooleanProperty(tickStat);
        this.isRefund = new SimpleBooleanProperty(isRef);
        this.refund = new SimpleDoubleProperty(ref);
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
    
    public void setTicketNum(int t) {
        ticketNum.set(t);
    }
    public IntegerProperty ticketNumProperty() {
        return ticketNum;
    }
    public int getTicketNum() {
        return ticketNum.get();
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

    public void setTicketStatus(Boolean d) {
        ticketStatus.set(d);
    }
    public BooleanProperty ticketStatusProperty() {
        return ticketStatus;
    }
    public Boolean getTicketStatus() {
        return ticketStatus.get();
    }

    public void setIsRefund(Boolean r) { isRefund.set(r); }
    public BooleanProperty isRefundProperty() {
        return isRefund;
    }
    public Boolean getIsRefund() {
        return isRefund.get();
    }

    public void setFare(double f) {
        fare.set(f);
    }
    public DoubleProperty fareProperty() {
        return fare;
    }
    public double getFare() {
        return fare.get();
    }

    public void setDiscount(double d) {
        discount.set(d);
    }
    public DoubleProperty discountProperty() {
        return discount;
    }
    public double getDiscount() {
        return discount.get();
    }

    public void setRefund(double r) {
        refund.set(r);
    }
    public DoubleProperty refundProperty() {
        return refund;
    }
    public double getRefund() {
        return refund.get();
    }


}

