package com.Classes;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
/*
    This Class is the most important class in the program, It is inherited by the two other QuizModels
    (TopicModel, DifficultModel).
    Defines the functionality of the Random quiz mode and Timer Mode.

 */


public class QuizModel {

    protected List<QuestionData> questions;
    protected int currentIndex;

    public QuizModel() {
        // Load questions from the CSV file or any other data source.
        questions = loadFromCSV();
        Collections.shuffle(questions); // Shuffle questions.
        currentIndex = 0;

    }

    public QuestionData getNextQuestion() {
        if (currentIndex < questions.size()) {
            return questions.get(currentIndex++); //List<QuestionData> questions.get(i) gets the next question from the List
        }
        return null; // No more questions.
    }




    private List<QuestionData> loadFromCSV(){ //loading the questions from the csv and adding them to a List
        List<QuestionData> questionList = new ArrayList<>();
        try {
            String filePath = "src/main/resources/questionbank.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String question = parts[0].trim();
                    String ans1 = parts[1].trim();
                    String ans2 = parts[2].trim();
                    String ans3 = parts[3].trim();
                    String ans4 = parts[4].trim();
                    String topic = parts[5].trim();
                    String diff = parts[6].trim();

                    //adding the options to string list options
                    List<String> options = new ArrayList<>();
                    options.add(ans1);
                    options.add(ans2);
                    options.add(ans3);
                    options.add(ans4);

                    // Shuffle the answer options.
                    Collections.shuffle(options);

                    // Create a new QuestionData object and add it to the <QuestionData> list.
                    QuestionData questionData = new QuestionData(question, options, ans1, diff, topic);
                    questionList.add(questionData);
                }
                else {
                }
            }
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return questionList; //returning the list of QuestionData objects
    }

}