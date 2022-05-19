package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label messegeLable;

    @FXML
    private TextField secretkeyText;

    @FXML
    private TextField usernameText;

//----------------------------------------------------Closing the Application window.------------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//-------------------------------------------------------Logging as a previous user.------------------------------------------------------------------------

    public void setLoginButtononAction(ActionEvent event) {

        String username = usernameText.getText();
        String secretKey = secretkeyText.getText();

        if(username.isBlank() == false && secretKey.isBlank() == false) {
            validateLogin();
        }
        else {
            messegeLable.setText("Incorrect Username or SecretKey");
        }
    }

//------------------------------------------------------------Validating Login.---------------------------------------------------------------

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameText.getText() + "' AND secretkey = '" + secretkeyText.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    messegeLable.setText("Congratulations!");

//-------------------------------------If already have a user  account, directly going to account page.---------------------------------------------------
                    try {

                        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                        Stage registerStage = new Stage();
                        registerStage.initStyle(StageStyle.TRANSPARENT);
                        Scene scene = new Scene(root);
                        scene.setFill(Color.TRANSPARENT);
                        registerStage.setScene(scene);
                        registerStage.show();

                        Stage stage = (Stage) loginButton.getScene().getWindow(); // Closing previous window.
                        stage.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }

                } else {
                    messegeLable.setText("Invalid login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

//-------------------------------------Going to Create account form when register button clicked.----------------------------------------------------

    public void createAccountForm() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            registerStage.setScene(scene);
            registerStage.show();

            Stage stage = (Stage) registerButton.getScene().getWindow(); // Closing previous window.
            stage.close();

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }




}