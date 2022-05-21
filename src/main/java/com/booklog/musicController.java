package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class musicController {

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;



//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//---------------------------------------------------------Go back to Menu page.-----------------------------------------------------------------

    public void setBackButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) backButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//----------------------------------------------------Navigate to Snow breezing music.-------------------------------------------------------------

    public void setSnowButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//----------------------------------------------------Navigate to Mind relaxing music.-------------------------------------------------------------

    public void setRelaxButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//-------------------------------------------------Navigate to Raining and Thundering music.-------------------------------------------------------------

    public void setRainButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//----------------------------------------------------Navigate to Deep sleeping music.-------------------------------------------------------------

    public void setSleepButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}

