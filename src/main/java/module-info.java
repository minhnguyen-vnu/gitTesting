module com.jmc.loginform {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires mysql.connector.j;

    opens com.jmc.loginform to javafx.fxml;
    exports com.jmc.loginform;
}