package com.kuby_clientlourd.kuby_clientlourd.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class MainController {

    @FXML
    private Pane contentArea;

    public void setPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Pane newPage = loader.load();
            contentArea.getChildren().setAll(newPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
