/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Matthew Kasperavicius (mkasper2) & Garvan Doyle (gdoyle6)
 *
 * PLEASE NOTE SPECIAL ADDITION
 * Under the File Menu option we included the functionality to reset the DataBase
 * Also under Flights & Employee Menu Options we created the functionality to view the table from the database.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("iTravel.fxml"));

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("iTravel");

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
