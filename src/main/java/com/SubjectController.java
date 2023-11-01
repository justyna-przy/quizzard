package com;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SubjectController {

    private Button dmaths, compsci, comporg;

    @FXML
    private Button exit, statsBtn, homeBtn;

    public void goHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/home.fxml", null, null, null);
    }


    public void goToStats(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/stats.fxml", null, null, null);
    }


    public void exitApp(ActionEvent event){
        Platform.exit();
    }
    public void selectCompsci(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Topic", null,  "Compsci");
    }

    public void selectDMaths(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Topic", null,  "Discrete");
    }

    public void selectComporg(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Topic", null,  "Comporg");
    }
}
