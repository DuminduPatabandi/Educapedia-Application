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
import java.sql.Connection;

public class MenuController {

    @FXML
    private Button StudyMusicButton;

    @FXML
    private Button accountinfoButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button firstGoButton;

    @FXML
    private Button fourthGoButton;

    @FXML
    private Button secondGoButton;

    @FXML
    private Button thirdGoButton;

    @FXML
    private Button goOurSiteButton;

//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//-----------------------------------------------------------Go to first year page.-----------------------------------------------------------------------

    public void setFirstGoButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("firstyear.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) firstGoButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//-----------------------------------------------------------Go to second year page.-----------------------------------------------------------------------

    public void setSecondGoButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("secondyear.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) secondGoButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//-----------------------------------------------------------Go to third year page.-----------------------------------------------------------------------

    public void setThirdGoButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("thirdyear.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) thirdGoButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//-----------------------------------------------------------Go to fourth year page.-----------------------------------------------------------------------

    public void setFourthGoButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("fourthyear.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) fourthGoButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


//-----------------------------------------------------------Go to Study music page.-----------------------------------------------------------------------

    public void setMusicButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("music.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) StudyMusicButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//----------------------------------------------Go to User Info tab without closing the Menu tab.-------------------------------------------------------------

    public void setAccountinfoButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("accountinfo.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) accountinfoButton.getScene().getWindow(); // Closing previous window.
            stage.close();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//----------------------------------------------Through this button user can visit our website.-------------------------------------------------------------

    public void setGoOurSiteButtonOnAction(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.apebodima.com";
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


}
