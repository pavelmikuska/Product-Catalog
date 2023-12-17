module com.pavelmikuska.productcatalog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.pavelmikuska.productcatalog to javafx.fxml;
    exports com.pavelmikuska.productcatalog;
}