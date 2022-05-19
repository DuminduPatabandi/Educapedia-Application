package com.booklog;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteController {

    @FXML
    private Button backButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private TextField usernameText;

    @FXML
    private Label messageDisplay;


//-------------------------------------------------------Go back to account info page.----------------------------------------------------------------------

    public void setbackButtonAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("accountinfo.fxml"));
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

//-------------------------------------------------------Terminating the application.----------------------------------------------------------------------

    public void setDeleteAccountButtonOnAction(ActionEvent event) {

        if (usernameText.getText().isBlank() == false) {
            deleteUser();


            /**
             *  In here application will be terminated if the account deletion is successful.
             */

            try {

                Parent root = FXMLLoader.load(getClass().getResource("termination.fxml"));
                Stage registerStage = new Stage();
                registerStage.initStyle(StageStyle.UNDECORATED);
                Scene scene = new Scene(root);
                registerStage.setScene(scene);
                registerStage.show();

                Stage stage = (Stage) deleteAccountButton.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        } else {
            messageDisplay.setText("Deletion not Success.");
        }

    }

//---------------------------------------------------------Deleting user accounts.----------------------------------------------------------------------

    public void deleteUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameText.getText();

        String deleteUser = "DELETE FROM `user_account` WHERE username = '"+username+"'";

        try {

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(deleteUser);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }



}
