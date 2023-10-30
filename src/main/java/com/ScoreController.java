package com;

import com.Classes.ScoreHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ScoreController {
    @FXML
    private Label score;

    @FXML
    private Button scoreButton;

    @FXML
    private Button nextStats;

    public void revealScore(javafx.event.ActionEvent event) {
        score.setText(Integer.toString(ScoreHandler.getScore()));
    }


    public void onNextStatsButtonClicked(javafx.event.ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/stats.fxml");
    }
}
