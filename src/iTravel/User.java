package iTravel;

import javafx.beans.property.*;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 */
public class User {

    private final IntegerProperty iD;
    private final IntegerProperty password;

    public User(){
        this.iD = new SimpleIntegerProperty(0);
        this.password = new SimpleIntegerProperty(0);
    }

    public User(int id, int pWord) {
        this.iD = new SimpleIntegerProperty(id);
        this.password = new SimpleIntegerProperty(pWord);
    }


    public void setiD(int ID) {
        iD.set(ID);
    }
    public IntegerProperty iDProperty() {
        return iD;
    }
    public int getID() {
        return iD.get();
    }

    public void setPassword(int p) {
        password.set(p);
    }
    public IntegerProperty passwordProperty() {
        return password;
    }
    public int getPassword() {
        return password.get();
    }


}

