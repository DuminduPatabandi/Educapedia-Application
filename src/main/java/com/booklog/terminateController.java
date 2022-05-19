package com.booklog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class terminateController {

    @FXML
    private Button closeButton;

//------------------------------------------------------Closing the Application window.-----------------------------------------------------------------------

    public void setCloselButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
