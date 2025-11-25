package com.foldrent.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button proceedButton;
    @FXML private Hyperlink loginButton;
    @FXML private ComboBox<String> roleDropdown;

    @FXML
    private void initialize() {
        // Set up the role dropdown options
        ObservableList<String> roles = FXCollections.observableArrayList(
            "Tenant",
            "Landlord"
        );
        roleDropdown.setItems(roles);
        roleDropdown.setValue("Tenant"); // Set default value
    }

    @FXML
    private void handleProceed() {
        String selectedRole = roleDropdown.getValue();
        System.out.println("Proceed button clicked - Selected role: " + selectedRole);
        showAlert("Proceed", "Selected role: " + selectedRole + "\nAccount creation coming soon!");
    }

    @FXML
    private void handleLoginLink() {
        System.out.println("Login link clicked");
        showAlert("Login", "Redirecting to login...");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}