package com.foldrent.javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Hyperlink registerButton;

    @FXML
    private void handleLogin() {
        System.out.println("Login button clicked");
        showAlert("Login", "Login functionality coming soon!");
    }

    @FXML
    private void handleRegisterButton() {
        System.out.println("Register button clicked");
        showAlert("Register", "Redirecting to registration...");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}