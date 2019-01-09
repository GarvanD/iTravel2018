package iTravel;

import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class Flights {
    private final IntegerProperty flightNumber;
    private final StringProperty origin;
    private final StringProperty  destination;
    private final IntegerProperty busSeats;
    private final IntegerProperty execSeats;
    private final DoubleProperty busFare;
    private final DoubleProperty execFare;
    private final IntegerProperty totalReservation;
    private final StringProperty flightTime;
    private final StringProperty aircraftType;
    private final DoubleProperty flightRevenue;


    public Flights(int num, String origin, String destination, int num2, int num3) {
        this(num, origin, destination, num2,num3, 0, 0, 0, "00", "Plane", 0);
    }

    public Flights(int num, String origin, String destination, int busSeats, int execSeats, double busFare, double execFare, int totalReseravation, String flightTime, String aircraftType, double flightRevenue) {
        this.flightNumber = new SimpleIntegerProperty(num);
        this.origin = new SimpleStringProperty(origin);
        this.destination = new SimpleStringProperty(destination);
        this.busSeats = new SimpleIntegerProperty(busSeats);
        this.execSeats = new SimpleIntegerProperty(execSeats);
        this.busFare = new SimpleDoubleProperty(busFare);
        this.execFare = new SimpleDoubleProperty(execFare);
        this.totalReservation = new SimpleIntegerProperty(totalReseravation);
        this.flightTime = new SimpleStringProperty(flightTime);
        this.aircraftType = new SimpleStringProperty(aircraftType);
        this.flightRevenue = new SimpleDoubleProperty(flightRevenue);
    }

    public void setFlightNumber(int num) {
        flightNumber.set(num);
    }
    public IntegerProperty flightNumberProperty() {
        return flightNumber;
    }
    public int getflightNumber() {
        return flightNumber.get();
    }
    
    public void setOrigin(String home) {
        origin.set(home);
    }
    public StringProperty originProperty() {
        return origin;
    }
    public String getOrigin() {
        return origin.get();
    }
   
    public void setDestination(String dest) {
        destination.set(dest);
    }
    public StringProperty destinationProperty() {
        return destination;
    }
    public String getDestination() {
        return destination.get();
    }
    

    public void setBusSeats(int num) {
        busSeats.set(num);
    }
    public IntegerProperty busSeatsProperty() {
        return busSeats;
    }
    public int getBusSeats() {
        return busSeats.get();
    }
    
    
    public void setExecSeats(int num) {
        execSeats.set(num);
    }
    public IntegerProperty execSeatsProperty() {
        return execSeats;
    }
    public int getExecSeats() {
        return execSeats.get();
    }

    public void setTotalReservation(int num) {
        totalReservation.set(num);
    }
    public IntegerProperty totalReservationProperty() {
        return totalReservation;
    }
    public int getTotalReservation() {
        return totalReservation.get();
    }

    public void setBusFare(double num) {
        busFare.set(num);
    }
    public DoubleProperty busFareProperty() {
        return busFare;
    }
    public double getBusFare() {
        return busFare.get();
    }

    public void setExecFare(double num) {
        execFare.set(num);
    }
    public DoubleProperty execFareProperty() {
        return execFare;
    }
    public double getExecFare() {
        return execFare.get();
    }

    public void setFlightRevenue(double num) {
        flightRevenue.set(num);
    }
    public DoubleProperty flightRevenueProperty() {
        return flightRevenue;
    }
    public double getFlightRevenue() {
        return flightRevenue.get();
    }

    public void setFlightTime(String ft) {
        flightTime.set(ft);
    }
    public StringProperty flightTimeProperty() {
        return flightTime;
    }
    public String getFlightTime() {
        return flightTime.get();
    }

    public void setAircraftType(String _at) { aircraftType.set(_at); }
    public StringProperty aircraftTypeProperty() {
        return aircraftType;
    }
    public String getAircraftType() {
        return aircraftType.get();
    }
}

