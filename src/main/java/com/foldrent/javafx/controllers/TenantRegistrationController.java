package com.foldrent.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.event.ActionEvent;

public class TenantRegistrationController {

    @FXML private TextField middleinitialField;
    @FXML private TextField lastnameField;
    @FXML private TextField firstnameField;
    @FXML private TextField emailField;
    @FXML private TextField contactnumField;
    @FXML private DatePicker birthdateField;
    @FXML private RadioButton maleRadio;
    @FXML private RadioButton femaleRadio;
    @FXML private Button registerButton;
    @FXML private Hyperlink loginButton;
    @FXML private Button backButton;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private void handleRegister() {
        
    }

    @FXML
    private void handleLoginLink() {
        System.out.println("Login link clicked");
        showAlert("Login", "Redirecting to login...");
    }

    @FXML
    private void handleBack() {
        System.out.println("Back button clicked");
        showAlert("Back", "Going back...");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}