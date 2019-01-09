package iTravel;

import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */

public class Customer extends User {

    private final IntegerProperty customerID;
    private final StringProperty customerName;
    private final StringProperty commonDestination;
    private final StringProperty  commonSeatClass;
    private final IntegerProperty numberOfFlights;
    private final DoubleProperty totalFare;
    private final IntegerProperty paymentInfo;
    private final StringProperty emailID;

    public Customer(int iD, String nm, String cD, String cSc, int numF) {this(iD, nm, cD, cSc, numF, 0,111,"123@gmail.com",123);}


    public Customer(int iD, String nm, String cD, String cSc, int numF, double totalF, int pay, String mail, int pWord) {
        this.numberOfFlights = new SimpleIntegerProperty(numF);
        this.commonDestination = new SimpleStringProperty(cD);
        this.commonSeatClass = new SimpleStringProperty(cSc);
        this.customerID = new SimpleIntegerProperty(iD);
        this.totalFare = new SimpleDoubleProperty(totalF);
        this.paymentInfo = new SimpleIntegerProperty(pay);
        this.emailID = new SimpleStringProperty(mail);
        this.customerName = new SimpleStringProperty(nm);
        super.setiD(iD);
        super.setPassword(pWord);
    }


    public void setCustomerName(String _name) {
        customerName.set(_name);
    }
    public StringProperty customerNameProperty() {
        return customerName;
    }
    public String getCustomerName() {
        return customerName.get();
    }
    
    public void setEmailID(String id) {
        emailID.set(id);
    }
    public StringProperty emailIDProperty() {
        return emailID;
    }
    public String getEmailID() {
        return emailID.get();
    }
    
    public void setPaymentInfo(int fc) {
        paymentInfo.set(fc);
    }
    public IntegerProperty paymentInfoProperty() {
        return paymentInfo;
    }
    public int getPaymentInfo() {
        return paymentInfo.get();
    }

    public void setTotalFare(double f) {
        totalFare.set(f);
    }
    public DoubleProperty totalFareProperty() {
        return totalFare;
    }
    public double getTotalFare() {
        return totalFare.get();
    }

    public void setCustomerID(int id) {
        customerID.set(id);
    }
    public IntegerProperty customerIDProperty() {
        return customerID;
    }
    public int getCustomerID() {
        return customerID.get();
    }

    public void setCommonSeatClass(String sc) {
        commonSeatClass.set(sc);
    }
    public StringProperty commonSeatClassProperty() {
        return commonSeatClass;
    }
    public String getCommonSeatClass() {
        return commonSeatClass.get();
    }

    public void setCommonDestination(String d) {
        commonDestination.set(d);
    }
    public StringProperty commonDestinationProperty() {
        return commonDestination;
    }
    public String getCommonDestination() {
        return commonDestination.get();
    }

    public void setNumberOfFlights(int num) {
        numberOfFlights.set(num);
    }
    public IntegerProperty numberOfFlightsProperty() {
        return numberOfFlights;
    }
    public int getNumberOfFlights() {
        return numberOfFlights.get();
    }

}

