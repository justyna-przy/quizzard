package com.Classes;

import java.util.List;





public class QuestionData {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String difficulty; // Add a difficulty field.

    private String topic;
    //TODO: add topic to question data and implement quiz topic mode

    public QuestionData(String question, List<String> options, String correctAnswer, String difficulty, String topic) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTopic(){
        return topic;
    }
}