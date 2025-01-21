package com.kuby_clientlourd.kuby_clientlourd.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SidebarController {

    private MainController mainController;

    // Méthode pour définir le MainController depuis l'application principale
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void loadStockManagement() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/stockManagement.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void loadClientList() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/listClient.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void loadSupplierList() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierList.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void loadClientOrder() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientOrder.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void loadSupplierOrder() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierOrder.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    public void showAdminLogin() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/adminLogin.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    public void showSupplierOrderInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierOrderInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    public void showSupplierInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    public void showClientInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    public void showClientOrderInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientOrderInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

}
