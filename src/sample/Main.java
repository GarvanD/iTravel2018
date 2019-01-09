//Created by Garvan Doyle (gdoyle6) & Matt Kasper (mkasper2)

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("iTravel");
        primaryStage.setScene(new Scene(root, 1080, 720));
        javafx.scene.image.Image applicationIcon = new Image(getClass().getResourceAsStream("WesternLogo.png"));
        primaryStage.getIcons().add(applicationIcon);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
