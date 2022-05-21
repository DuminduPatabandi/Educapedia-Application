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
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class editController {

    @FXML
    private Button backButton;

    @FXML
    private Button changeNameButton;

    @FXML
    private Button changePwButton;

    @FXML
    private Button changeTelButton;

    @FXML
    private TextField newNameText;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField newTelText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField telText;

    @FXML
    private TextField usernameText;


    @FXML
    private ImageView contactCheck;

    @FXML
    private ImageView nameCheck;

    @FXML
    private ImageView passwordCheck;

    @FXML
    private Label displayHeader;


//---------------------------------------------------------Go back to userinfo page.-----------------------------------------------------------------

    public void setBackButtonOnAction(ActionEvent event) {
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

//------------------------------------------------------------Edit username.--------------------------------------------------------------------------

    public void changeNameButton() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameText.getText();
        String newUsername = newNameText.getText();

        String editName = "UPDATE `user_account` SET username = '" + newUsername + "' WHERE username = '" + username + "'";
        String verifyUsername = "SELECT count(1) FROM user_account WHERE username = '" + username + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyUsername);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    displayHeader.setText("username changed.");
                    Image image = new Image(getClass().getResourceAsStream("icons8-check-all-48.png"));
                    nameCheck.setImage(image);

                    try {

                        statement.executeUpdate(editName);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();

                    }
                } else {
                    displayHeader.setText("username not found.");
                    Image image = new Image(getClass().getResourceAsStream("wrong.png"));
                    nameCheck.setImage(image);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

//----------------------------------------------------------Edit secret key.------------------------------------------------------------------------

    public void changePwButton() {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String secretKey = passwordText.getText();
            String newSecretKey = newPassword.getText();

            String editSecretKey = "UPDATE `user_account` SET secretkey = '" + newSecretKey + "' WHERE secretkey = '" + secretKey + "'";
            String verifySkey = "SELECT count(1) FROM user_account WHERE secretkey = '" + secretKey+ "'";

            try {

                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifySkey);

                while (queryResult.next()) {
                    if (queryResult.getInt(1) == 1) {
                        displayHeader.setText("secretkey changed.");
                        Image image = new Image(getClass().getResourceAsStream("icons8-check-all-48.png"));
                        passwordCheck.setImage(image);

                        try {

                            statement.executeUpdate(editSecretKey);

                        } catch (Exception e) {
                            e.printStackTrace();
                            e.getCause();

                        }
                    } else {
                        displayHeader.setText("secretkey not found.");
                        Image image = new Image(getClass().getResourceAsStream("wrong.png"));
                        passwordCheck.setImage(image);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }
        }

//----------------------------------------------------------Edit contact number.------------------------------------------------------------------------

    public void changeTelButton() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String contactNo = telText.getText();
        String newContactNo = newTelText.getText();

        String editTel = "UPDATE `user_account` SET contactNo = '" + newContactNo + "' WHERE contactNo = '" + contactNo + "'";
        String verifyTel = "SELECT count(1) FROM user_account WHERE contactNo = '" + contactNo + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyTel);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    displayHeader.setText("contact No changed.");
                    Image image = new Image(getClass().getResourceAsStream("icons8-check-all-48.png"));
                    contactCheck.setImage(image);

                    try {

                        statement.executeUpdate(editTel);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();

                    }
                } else {
                    displayHeader.setText("contact No not found.");
                    Image image = new Image(getClass().getResourceAsStream("wrong.png"));
                    contactCheck.setImage(image);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }


}
