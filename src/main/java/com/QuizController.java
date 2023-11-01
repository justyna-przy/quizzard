package com;

import com.Classes.*;
import com.ScoreController;
import javafx.application.Platform;
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
    private QuizModel difficultModel;
    private QuizModel topicModel;

    private QuestionData currentQuestion;

    @FXML
    private Button exit, statsBtn, homeBtn;

    public void goHome(ActionEvent event){

    }


    public void goToStats(ActionEvent event) {
    }


    public void exitApp(ActionEvent event){
        Platform.exit();
    }

    Score score = new Score();
    String userChoice;
    int questionNum = 1;

    QuizModel quizMode;


    @FXML
    public void initialize(String mode, String difficulty, String topic) {
        if ("Random".equals(mode)) {
            quizModel = new QuizModel(); // Initialize the QuizModel for random mode
            setQuizModel(quizModel);
            loadQuestion(quizModel);
        } else if ("Difficulty".equals(mode)) {
            difficultModel = new DifficultModel(difficulty); // Initialize the DifficultModel for difficulty mode
            setQuizModel(difficultModel);
            loadQuestion(difficultModel);
        } else if ("Topic".equals(mode)) {
            topicModel = new TopicModel(topic); // Initialize the DifficultModel for difficulty mode
            setQuizModel(topicModel);
            loadQuestion(topicModel);
        } else if ("Survival".equals(mode)) {
            // Initialize the quiz model for survival mode, if needed
            // Add your logic here
        }



    }

    private void setQuizModel(QuizModel quizModel) {
        quizMode = quizModel;
    }


    @FXML
    private void onNextButtonClicked(ActionEvent event) throws IOException {
        if(userChoice == null){
            return;
        }
        else if(userChoice.equals(currentQuestion.getCorrectAnswer())){
            score.incScore();
            System.out.println("new score: " + score.getScore());
        }
        userChoice = null;
        questionNum++;
        loadQuestion(quizMode);
    }



    public void loadQuestion(QuizModel model){

        try {
            resetRadioButton();
            currentQuestion = model.getNextQuestion();

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
                ScoreHandler.setScore(score.getScore());
                scorePage();
                //change to score here once you run out of Q's
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }




    private void scorePage() throws IOException {
        Main m = new Main();
        m.changeScene("/score.fxml", null, null, null);


        // Pass the user's score to ScoreController

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
