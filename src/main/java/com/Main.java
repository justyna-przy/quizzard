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

    public void changeScene(String fxml, String mode, String difficulty, String topic) throws IOException{
        //this method changes the current scene to a different scene
        //it maintains the stage and the stage width and height
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        if (fxml.equals("/quiz.fxml")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            QuizController controller = loader.getController();
            controller.initialize(mode, difficulty, topic); // Pass the mode here
            stg.getScene().setRoot(root);
        }else if (fxml.equals("/stats.fxml")){

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            StatsController controller = loader.getController();
            controller.initializeStats();
            stg.getScene().setRoot(root);

        } else {
            stg.getScene().setRoot(pane);
        }

    }

    public static void main(String[] args) {
        launch(args);

    }

    // TODO: make the error message change when password is too long
    // TODO: difficulties rather than subject
    // TODO: document?
    // TODO: Stats method
    // TODO: Look over code and comment
}