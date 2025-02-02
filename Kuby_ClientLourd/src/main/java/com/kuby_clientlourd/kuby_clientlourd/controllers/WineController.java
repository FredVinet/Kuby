package com.kuby_clientlourd.kuby_clientlourd.controllers;

import com.kuby_clientlourd.kuby_clientlourd.interfaces.wine.Wine;
import com.kuby_clientlourd.kuby_clientlourd.services.wine.WineService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.List;

public class WineController {
    @FXML
    private TableView<Wine> clientTable;
    @FXML
    private TableColumn<Wine, Integer> idColumn;
    @FXML
    private TableColumn<Wine, String> descriptionColumn;
    @FXML
    private TableColumn<Wine, String> nameColumn;
    @FXML
    private TableColumn<Wine, String> varietyColumn;
    @FXML
    private TableColumn<Wine, String> familyColumn;
    @FXML
    private TableColumn<Wine, Integer> yearColumn;
    @FXML
    private TableColumn<Wine, String> supplierColumn;
    @FXML
    private TableColumn<Wine, Integer> stockColumn;

    private final WineService wineService = new WineService();
    private final ObservableList<Wine> wineList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Associer les colonnes aux propriétés du modèle
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        varietyColumn.setCellValueFactory(new PropertyValueFactory<>("variety_id"));
        familyColumn.setCellValueFactory(new PropertyValueFactory<>("wine_family_id"));

        // Charger les vins
        loadWines();
    }

    private void loadWines() {
        try {
            List<Wine> wines = wineService.getAllWines();
            wineList.setAll(wines);
            clientTable.setItems(wineList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
