package com.kuby_clientlourd.kuby_clientlourd.controllers;

import javafx.fxml.FXML;

public class SidebarController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void showStockManagement() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/stockManagement.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void showClientList() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/listClient.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void showSupplierList() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierList.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void showClientOrder() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientOrder.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    private void showSupplierOrder() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierOrder.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showAdminLogin() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/adminLogin.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showSupplierOrderInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierOrderInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showSupplierInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/supplierInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showClientInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showClientOrderInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/clientOrderInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

    @FXML
    public void showProductInfo() {
        if (mainController != null) {
            mainController.setPage("/com/kuby_clientlourd/kuby_clientlourd/view/productInfo.fxml");
        } else {
            System.out.println("MainController n'est pas défini !");
        }
    }

}
