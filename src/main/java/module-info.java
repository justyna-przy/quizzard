module com {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.mail;

    opens com to javafx.fxml;
    exports com;


}