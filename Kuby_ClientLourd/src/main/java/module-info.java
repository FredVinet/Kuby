module com.kuby_clientlourd.kuby_clientlourd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;

    opens com.kuby_clientlourd.kuby_clientlourd to javafx.fxml;
    exports com.kuby_clientlourd.kuby_clientlourd;
    exports com.kuby_clientlourd.kuby_clientlourd.controller;
    opens com.kuby_clientlourd.kuby_clientlourd.controller to javafx.fxml;
}