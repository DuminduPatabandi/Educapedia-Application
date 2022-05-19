module com.booklog {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.media;


    opens com.booklog to javafx.fxml;
    exports com.booklog;
}