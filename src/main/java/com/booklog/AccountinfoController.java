package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

public class AccountinfoController {

    @FXML
    private Label firstnameView;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private Label lastnameView;

    @FXML
    private Button editAccountButton;

    @FXML
    private Label emailView;

    @FXML
    private Label useridView;

    @FXML
    private TextField usernameText;

    @FXML
    private Button backButton;

    @FXML
    private Button goButton;


//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//------------------------------------------------------Navigating to edit account window.-----------------------------------------------------------------------

    public void editAccountOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("editaccount.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) editAccountButton.getScene().getWindow();
            stage.close();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//------------------------------------------------------Navigating to delete account window.-----------------------------------------------------------------------

    public void deleteAccountOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("deleteAccount.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) deleteAccountButton.getScene().getWindow();
            stage.close();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
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

//------------------------------------------------------------Display account details.-----------------------------------------------------------------

    public void setGoButtonOnAction(ActionEvent event) {
        if(usernameText.getText().isBlank() == false) {
            userInfoDisplay();
        }
        else {
            useridView.setText("Please enter a valid username");
            firstnameView.setText("Please enter a valid username");
            lastnameView.setText("Please enter a valid username");
            emailView.setText("Please enter a valid username");
        }
    }
/*
    public void userInfoDisplay() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameText.getText();

        String findUser = "SELECT * FROM `user_account` WHERE username = '" + username + "'";
        String findUserName = "SELECT username FROM `user_account` WHERE username = '" + username + "'";
        //String findUser = "SELECT count(1)  FROM `user_account` WHERE username = '" + username + "'";
        //String findUser = "SELECT count(1) user_id,firstname,lastname,email FROM `user_account` WHERE username = '" + username + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(findUser);

            while (queryResult.next()) {
                if (queryResult.getString("username").equals(findUserName.equals(username))) {
                    useridView.setText("user_id");
                    firstnameView.setText("Display firstName");
                    lastnameView.setText("Display lastName");
                    emailView.setText("Display email");

                } else {
                    useridView.setText("Please enter a valid username");
                    firstnameView.setText("Please enter a valid username");
                    lastnameView.setText("Please enter a valid username");
                    emailView.setText("Please enter a valid username");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }*/


//----------------------------------------------------------Display username.--------------------------------------------------------------------------

    public void userInfoDisplay() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameText.getText();
        //String user_id = usernameText.getText();

        String userid = "SELECT user_id FROM `user_account` WHERE username = '" + username + "'";
        String verifyUsername = "SELECT count(1) FROM user_account WHERE username = '" + username + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyUsername);
            ResultSet queryResult2 = statement.executeQuery(userid);

            while (queryResult.next() && queryResult2.next()) {
                if (queryResult.getInt(1) == 1) {


                    try {

                        statement.executeUpdate(userid);
                        useridView.setText(userid);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();

                    }
                } else {
                    useridView.setText("Please enter a valid username");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }
}