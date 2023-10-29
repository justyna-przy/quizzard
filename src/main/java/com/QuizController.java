package com;

import com.Classes.QuizModel;
import com.Classes.QuestionData;
import com.Classes.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.*;

public class QuizController {

    @FXML
    private Label question;

    @FXML
    private Label questionNumLabel;

    @FXML
    private Button next;

    @FXML
    public RadioButton opt1, opt2, opt3, opt4;

    @FXML
    private ToggleGroup optionToggle;

    private QuizModel quizModel; // Add an instance of the QuizModel

    private QuestionData currentQuestion;

    Score score = new Score();
    String userChoice;
    int questionNum = 1;


    @FXML
    private void initialize() {
        quizModel = new QuizModel(); // Initialize the QuizModel
        loadQuestion();

    }


    @FXML
    private void onNextButtonClicked(ActionEvent event) {
        if(userChoice == null){
            return;
        }
        if(userChoice.equals(currentQuestion.getCorrectAnswer())){
            score.incScore();
            System.out.println("new score: " + score.getScore());
        }
        userChoice = null;
        questionNum++;
        loadQuestion();
    }



    private void loadQuestion(){

        try {
            resetRadioButton();
            currentQuestion = quizModel.getNextQuestion();

            if (currentQuestion != null) {
                String questionText = currentQuestion.getQuestion();
                List<String> options = currentQuestion.getOptions();
                question.setText(questionText);
                questionNumLabel.setText("Q" + questionNum + ".");
                opt1.setText(options.get(0));
                opt2.setText(options.get(1));
                opt3.setText(options.get(2));
                opt4.setText(options.get(3));

            } else {

                scorePage();
                //change to score here once you run out of Q's
            }
        }catch (Exception e){

        }

    }

    private void scorePage() throws IOException {
        Main m = new Main();
        m.changeScene("/score.fxml");
    }


    private void resetRadioButton(){
        for (RadioButton btn : new RadioButton[]{ opt1, opt2, opt3, opt4 }) {
            btn.setSelected(false);
        }

        //RadioButton[] radoptions = { opt1, opt2, opt3, opt4 };
        //for(int i = 0; i < radoptions.length; i++){
           // radoptions[i].setSelected(false);
        //}
    }

    @FXML
    public void opt1clicked(ActionEvent event){
        userChoice = opt1.getText();

    }

    @FXML
    public void opt2clicked(ActionEvent event){
        userChoice = opt2.getText();
    }

    @FXML
    public void opt3clicked(ActionEvent event){
        userChoice = opt3.getText();
    }

    @FXML
    public void opt4clicked(ActionEvent event){
        userChoice = opt4.getText();
    }



}
