package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);

        //this sets the initial scene to the login scene, it is the first thing the user sees
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));


        stage.setTitle("Quizzard");
        stage.setScene(new Scene(root, 1024 ,768));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        //this method changes the current scene to a different scene
        //it maintains the stage and the stage width and height
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);

    }
}