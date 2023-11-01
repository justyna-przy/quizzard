package com;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class SubjectController {

    private Button dmaths, compsci, comporg;
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
