//Created by Garvan Doyle (gdoyle6) & Matt Kasper (mkasper2)

package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {
    @FXML
    void openAbout(ActionEvent event)
    {
        //Instantiates new stage for dialog box
        Stage popupwindow=new Stage();

        //Changes Modality to Modal (The Dialog box will draw above the parent stage)
        popupwindow.initModality(Modality.APPLICATION_MODAL);

        //Sets title of the dialog box
        popupwindow.setTitle("About Us");

        //Instantiates and sets label text
        Label label1= new Label("iTravel\nCopyright @ 2018 SE2203a\nGarvan Doyle & Matthew Kasper");
        label1.setAlignment(Pos.CENTER);

        //Instantiates and sets button text
        Button button1= new Button("Ok");


        //When button1 is clicked an action event e is tracked and used to close the popup window
        // -> separates the parameter from the body of the lambda expression
        button1.setOnAction(e -> popupwindow.close());

        //Creates new vertical box layout for dialog box
        VBox layout= new VBox();
        //Sets Height and Width to the same as that of the Stage
        layout.setPrefHeight(250);
        layout.setPrefWidth(250);

        //Add button and label to layout
        layout.getChildren().addAll(label1, button1);

        //Align layout to centre
        layout.setAlignment(Pos.CENTER);

        //Instantiates and sets scene width and height
        Scene scene1= new Scene(layout, 250, 250);

        //Sets dialog bo to scene describe above
        popupwindow.setScene(scene1);

        //Sets the icon of the dialog window to the logo
        popupwindow.getIcons().add(
                new Image(this.getClass().getResource("WesternLogo.png").toString()));

        //Presents dialog box to user
        popupwindow.showAndWait();
    }



    @FXML
    //Provides functionality for close feature
    void close()
    {
        Platform.exit();
    }


}
