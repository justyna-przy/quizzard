package com;

import com.Classes.ScoreHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ScoreController {
    @FXML
    private Label score;

    @FXML
    private Button scoreButton;

    @FXML
    private Button nextStats;

    @FXML
    private Button exit, statsBtn, homeBtn;

    public void goHome(javafx.event.ActionEvent event){

    }


    public void goToStats(javafx.event.ActionEvent event) {
    }


    public void exitApp(ActionEvent event){
        Platform.exit();
    }

    public void revealScore(javafx.event.ActionEvent event) {
        score.setText(Integer.toString(ScoreHandler.getScore()));
    }


    public void onNextStatsButtonClicked(javafx.event.ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/stats.fxml", null, null, null);
    }


}
