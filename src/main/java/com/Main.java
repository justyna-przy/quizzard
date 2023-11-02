package com;

import com.Classes.CurrentUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the main class for the Quizzard program.
 * It serves as the entry point for the application.
 *
 *
 * Authors: Tom, Justyna
 * Date: November 1, 2023
 */



public class Main extends Application {

    private static Stage stg;

    //current user must be created in main method to be accessed from any class/controller
    private static CurrentUser currentUser;


    public static CurrentUser getCurrentUser() {

        return currentUser;
    }

    public static void setCurrentUser(CurrentUser user) {

        currentUser = user;
    }

    @Override
    public void start(Stage stage) throws IOException { //jfx starting point
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

        if (fxml.equals("/quiz.fxml")) { //how to handle the loading of quiz.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            QuizController controller = loader.getController();
            controller.initialize(mode, difficulty, topic); // pass the mode here
            stg.getScene().setRoot(root);
        }else if (fxml.equals("/stats.fxml")){ //loading stats.fxml

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            StatsController controller = loader.getController();
            controller.initializeStats(); //inti stats on loading of scene
            stg.getScene().setRoot(root);

        } else {
            stg.getScene().setRoot(pane);
        }

    }

    public static void main(String[] args) {
        launch(args);

    }

}