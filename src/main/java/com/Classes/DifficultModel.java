package com.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifficultModel extends QuizModel{
    public DifficultModel(String difficulty) {
        super();
        this.questions = loadDiff(difficulty);
        Collections.shuffle(this.questions);
        currentIndex = 0;

    }

    private List<QuestionData> loadDiff(String difficulty) {

        List<QuestionData> filteredQuestions = new ArrayList<>();

        for (QuestionData question : this.questions) {
            if (question.getDifficulty().equals(difficulty)) {
                filteredQuestions.add(question);
            }
        }

        return filteredQuestions;
    }

}
