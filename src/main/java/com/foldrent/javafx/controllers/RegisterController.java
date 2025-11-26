package com.foldrent.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button proceedButton;
    @FXML private Hyperlink loginButton;
    @FXML private RadioButton tenantButton;
    @FXML private RadioButton landlordButton;

    @FXML
    private void handleProceed() {
        //String selectedRole = roleDropdown.getValue();
        //System.out.println("Proceed button clicked - Selected role: " + selectedRole);
        //showAlert("Proceed", "Selected role: " + selectedRole + "\nAccount creation coming soon!");
    }

    @FXML
    private void handleLoginButton() {
        System.out.println("Login link clicked");
        showAlert("Login", "Redirecting to login...");
    }

    @FXML
    private void handleTenantRadio(){

    }
    @FXML
    private void handleLandlordRadio(){

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}