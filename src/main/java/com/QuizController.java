package com;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class QuizController {

    @FXML
    public Label question;

    @FXML
    public RadioButton opt1, opt2, opt3, opt4;

    int counter = 0; //counter for the questions answered
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize(){
        loadQuestion();
    }

    private void loadQuestion() {
    }


    @FXML
    public void opt1clicked(ActionEvent event){

    }

    @FXML
    public void opt2clicked(ActionEvent event){

    }

    @FXML
    public void opt3clicked(ActionEvent event){

    }

    @FXML
    public void opt4clicked(ActionEvent event){

    }

}
