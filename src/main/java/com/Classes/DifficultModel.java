package com.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifficultModel extends QuizModel{
    public DifficultModel(String difficulty) {
        super(); //call constructor of the superclass
        this.questions = loadDiff(difficulty); //get questions of certain difficulty and add to questions List
        Collections.shuffle(this.questions); //shuffle filtered questions.
        currentIndex = 0;

    }

    private List<QuestionData> loadDiff(String difficulty) {

        List<QuestionData> filteredQuestions = new ArrayList<>();


        //iterate through every question and add it to filteredQuestions if it matches the difficulty. (easy, med, hard)
        for (QuestionData question : this.questions) {
            if (question.getDifficulty().equals(difficulty)) {
                filteredQuestions.add(question);
            }
        }

        return filteredQuestions;
    }

}
