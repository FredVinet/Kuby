package com.kuby_clientlourd.kuby_clientlourd.controller;

import com.kuby_clientlourd.kuby_clientlourd.service.ApiService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class MainController {

    @FXML
    private ListView<String> wineFamilyList;

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

    @FXML
    public void loadAllWineFamilies() {
        new Thread(() -> {
            try {
                String jsonResponse = ApiService.get("/wines_family");
                JSONArray jsonArray = new JSONArray(jsonResponse);

                Platform.runLater(() -> {
                    wineFamilyList.getItems().clear();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        wineFamilyList.getItems().add(obj.getString("name"));
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
