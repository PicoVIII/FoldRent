package com.foldrent.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/foldrent/javafx/views/Login.fxml"));
        stage.setTitle("FoldRent");
        stage.setScene(new Scene(root, 720, 480));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}