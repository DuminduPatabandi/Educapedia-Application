package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterController {

    @FXML
    private Button RegisterButton;

    @FXML
    private Button StudyMusicButton;


    @FXML
    private Label messageDisplay;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField contactNoFiled;

    @FXML
    private TextField setsecretKey;

    @FXML
    private TextField userNameText;

    @FXML
    private CheckBox choiceStaff;

    @FXML
    private CheckBox choiceStudent;

//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

//------------------------------------------------------Opening Menu after registration.-----------------------------------------------------------------------

    public void setRegisterButtonAction(ActionEvent event) {
        if (userNameText.getText().isBlank() == false && setsecretKey.getText().isBlank() == false &&
            firstNameText.getText().isBlank() == false && lastNameText.getText().isBlank() == false &&
            emailField.getText().isBlank() == false && contactNoFiled.getText().isBlank() == false) {
            registerUser();

            /**
             *  In here user can advance to next phase if and only if the registration is successful.
             */
            try {

                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage registerStage = new Stage();
                registerStage.initStyle(StageStyle.TRANSPARENT);
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                registerStage.setScene(scene);
                registerStage.show();

                Stage stage = (Stage) RegisterButton.getScene().getWindow(); // Closing previous window.
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        } else {
            messageDisplay.setText("Registration not Success.");
        }
    }

//-------------------------------------------------------Registration of new users.-----------------------------------------------------------------------

    public void registerUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstNameText.getText();
        String lastname = lastNameText.getText();
        String username = userNameText.getText();
        String secretkey = setsecretKey.getText();
        String email = emailField.getText();
        String contactNo = contactNoFiled.getText();

        String insertFields = "INSERT INTO `user_account`(firstname, lastname, username, secretkey, email, contactNo) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + secretkey + "','" + email + "','" + contactNo + "')";
        String insertToRegister = insertFields + insertValues;

        try {

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            messageDisplay.setText("Registration Successful.");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



}


