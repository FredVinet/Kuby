package com.kuby_clientlourd.kuby_clientlourd;

import com.kuby_clientlourd.kuby_clientlourd.controllers.MainController;
import com.kuby_clientlourd.kuby_clientlourd.controllers.SidebarController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/kuby_clientlourd/kuby_clientlourd/view/main.fxml"));
        BorderPane root = mainLoader.load();

        MainController mainController = mainLoader.getController();

        FXMLLoader sidebarLoader = new FXMLLoader(getClass().getResource("/com/kuby_clientlourd/kuby_clientlourd/view/sidebar.fxml"));
        VBox sidebar = sidebarLoader.load();

        SidebarController sidebarController = sidebarLoader.getController();
        sidebarController.setMainController(mainController);

        root.setLeft(sidebar);

        Scene scene = new Scene(root, 1400, 700);
        scene.getStylesheets().add(getClass().getResource("/com/kuby_clientlourd/kuby_clientlourd/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kuby Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
