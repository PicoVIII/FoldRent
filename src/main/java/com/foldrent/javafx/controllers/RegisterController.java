package com.foldrent.javafx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button proceedButton;
    @FXML private Hyperlink loginButton;
    @FXML private RadioButton tenantButton;
    @FXML private RadioButton landlordButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    private void handleProceed() {
        //String selectedRole = roleDropdown.getValue();
        //System.out.println("Proceed button clicked - Selected role: " + selectedRole);
        //showAlert("Proceed", "Selected role: " + selectedRole + "\nAccount creation coming soon!");
    }

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/foldrent/javafx/views/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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