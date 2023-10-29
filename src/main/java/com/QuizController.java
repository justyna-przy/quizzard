package com;

import com.Classes.QuizModel;
import com.Classes.QuestionData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class QuizController {

    @FXML
    private Label question;

    @FXML
    private Button next;

    @FXML
    public RadioButton opt1, opt2, opt3, opt4;

    @FXML
    private ToggleGroup optionToggle;

    private QuizModel quizModel; // Add an instance of the QuizModel

    @FXML
    private void initialize() {
        quizModel = new QuizModel(); // Initialize the QuizModel
        loadQuestion();
    }


    @FXML
    private void onNextButtonClicked(ActionEvent event) {
        loadQuestion();
    }

    int counter = 0; //counter for the questions answered
    static int correct = 0;
    static int wrong = 0;


    private void loadQuestion() {

        // Use the QuizModel to load questions and answers
        QuestionData questionData = quizModel.getNextQuestion();

        if (questionData != null) {
            String questionText = questionData.getQuestion();
            List<String> options = questionData.getOptions();
            question.setText(questionText);
            opt1.setText(options.get(0));
            opt2.setText(options.get(1));
            opt3.setText(options.get(2));
            opt4.setText(options.get(3));

        } else {
            System.out.println("No");

            //change to score here once you run out of Q's
        }
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
