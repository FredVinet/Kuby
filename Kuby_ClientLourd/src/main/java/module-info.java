module com.kuby_clientlourd.kuby_clientlourd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.kuby_clientlourd.kuby_clientlourd to javafx.fxml;
    exports com.kuby_clientlourd.kuby_clientlourd;
}