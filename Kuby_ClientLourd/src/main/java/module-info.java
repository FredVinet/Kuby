module com.kuby_clientlourd.kuby_clientlourd {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.net.http;
    requires java.desktop;
    requires org.json;

    opens com.kuby_clientlourd.kuby_clientlourd to javafx.fxml;
    exports com.kuby_clientlourd.kuby_clientlourd;
    exports com.kuby_clientlourd.kuby_clientlourd.controllers;
    opens com.kuby_clientlourd.kuby_clientlourd.controllers to javafx.fxml;
}