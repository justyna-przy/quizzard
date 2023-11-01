package com;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button randomBtn, subjectBtn, difficultyBtn, survivalBtn;

    public void startRandom() throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Random", null, null);
    }

    public void startSubject() throws IOException {
        Main m = new Main();
        m.changeScene("/topicmode.fxml", null, null, null);

    }
    public void startDifficulty() throws IOException {
        Main m = new Main();
        m.changeScene("/difficulty.fxml", null, null, null);

    }
    public void startSurvival() throws IOException {

        Main m = new Main();
        m.changeScene("/quiz.fxml", "Survival", null, null);

    }
}
