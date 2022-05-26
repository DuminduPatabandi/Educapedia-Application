package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class secondyearController {

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;



//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//------------------------------------------------------------Go back to Menu page.-----------------------------------------------------------------

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

//--------------------------------------------------------Navigating to relevant web pages.-----------------------------------------------------------------------

//+++++++++++++++++| Downloading content |++++++++++++++++++++

    public void setAmatButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setPmatButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setCoscButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://drive.google.com/file/d/1CKh4NGbNkPlxnqz_eLHFEMeLGsfoUTa9/view?usp=sharing";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setCostButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setPhysButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setChemButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setElecButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void setStatButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.google.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//+++++++++++++++++++| Uploading content |+++++++++++++++++++++

    public void setUploadButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSeG5yXDa2mnRXN2WtoXiougxKl3XYH86__5Trf-aETRW1Tf4w/viewform?usp=sf_link";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
