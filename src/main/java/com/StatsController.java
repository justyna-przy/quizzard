package com;

import com.Classes.CurrentUser;
import com.Classes.Stats;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.List;

public class StatsController {

    @FXML
    private Label userMean, userMedian, userSD, yourMean, yourMedian, yourSD, yourStats;

    @FXML
    private Button exit, statsBtn, homeBtn;

    public void goHome(ActionEvent event){

    }


    public void goToStats(ActionEvent event) {
    }


    public void exitApp(ActionEvent event){
        Platform.exit();
    }

    private CurrentUser currentUser;

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }



    public void initializeStats() {
        Stats quizStats = new Stats();
        quizStats.loadCSVScores();
        yourStats.setText("Your Statistics, "+ Main.getCurrentUser().getUsername() + "!");
        userMean.setText(String.valueOf(quizStats.calcUserMean()));
        userMedian.setText(String.valueOf(quizStats.calcUserMedian()));
        userSD.setText(String.valueOf(quizStats.calcUserSD()));

        //bug
        List<Double> yourScores = quizStats.findYourScore(Main.getCurrentUser().getUsername());
        yourMean.setText(String.valueOf(quizStats.findYourMean(yourScores)));
        yourMedian.setText(String.valueOf(quizStats.findYourMedian(yourScores)));
        yourSD.setText(String.valueOf(quizStats.findYourSD(yourScores)));

    }


}
