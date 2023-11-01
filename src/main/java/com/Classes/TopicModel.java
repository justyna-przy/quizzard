

package com.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopicModel extends QuizModel{
    public TopicModel(String topic) {
        super();

        this.questions = loadDiff(topic);
        Collections.shuffle(this.questions);
        currentIndex = 0;

    }

    private List<QuestionData> loadDiff(String topic) {

        List<QuestionData> filteredQuestions = new ArrayList<>();


        for (QuestionData question : this.questions) {
            if (question.getTopic().equals(topic)) {
                filteredQuestions.add(question);
            }
        }

        return filteredQuestions;
    }

}
