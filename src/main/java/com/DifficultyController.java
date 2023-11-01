package com;

import com.Classes.DifficultModel;
import com.Classes.QuizModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class DifficultyController {

    @FXML
    private Button novice, intermed, expert;


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






    public void selectIntermedd(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Difficulty", "medium", null);

    }

    public void selectNovice(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Difficulty", "easy", null);
    }

    public void selectExpert(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/quiz.fxml", "Difficulty", "hard", null);
    }
}
