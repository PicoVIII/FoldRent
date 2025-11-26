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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class RegisterController implements Initializable{

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button proceedButton;
    @FXML private Hyperlink loginButton;
    @FXML private RadioButton tenantRadio;
    @FXML private RadioButton landlordRadio;
    @FXML private ToggleGroup roleGroup;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private boolean isTenantSelected;
    private boolean isLandlordSelected;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // Create a ToggleGroup programmatically if not set in FXML
        roleGroup = new ToggleGroup();
        tenantRadio.setToggleGroup(roleGroup);
        landlordRadio.setToggleGroup(roleGroup);

        // Optionally set user data to identify the selected role
        tenantRadio.setUserData("Tenant");
        landlordRadio.setUserData("Landlord");

        // Listen for changes
        roleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                String selectedRole = newToggle.getUserData().toString();
                System.out.println("Role selected: " + selectedRole);
            }
        });
    }

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
        isTenantSelected = true;

        if(isTenantSelected){
            isLandlordSelected = false;
        }
    }
    @FXML
    private void handleLandlordRadio(){
        isLandlordSelected = true;

        if(isLandlordSelected){
            isTenantSelected = false;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}