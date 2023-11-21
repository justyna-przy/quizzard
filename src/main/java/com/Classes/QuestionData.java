package com.Classes;

import java.util.List;

/**
 * The QuestionData class represents a question in the quiz with its options.
 * It encapsulates the question text, answer options, correct answer, difficulty, and topic.
 */
public class QuestionData {

    // The text of the question.
    private String question;

    // The list of answer options for the question.
    private List<String> options;

    // The correct answer for the question.
    private String correctAnswer;

    // The difficulty level of the question.
    private String difficulty;

    // The topic/category to which the question belongs.
    private String topic;

    /**
     * Constructor for creating a new QuestionData object.
     *
     * @param question      The text of the question.
     * @param options       The list of answer options for the question.
     * @param correctAnswer The correct answer for the question.
     * @param difficulty    The difficulty level of the question.
     * @param topic         The topic/category to which the question belongs.
     */
    public QuestionData(String question, List<String> options, String correctAnswer, String difficulty, String topic) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.topic = topic;
    }

    /**
     * Gets the text of the question.
     *
     * @return The question text.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the list of answer options for the question.
     *
     * @return The list of answer options.
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Gets the correct answer for the question.
     *
     * @return The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Gets the difficulty level of the question.
     *
     * @return The difficulty level.
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the topic/category to which the question belongs.
     *
     * @return The topic/category.
     */
    public String getTopic() {
        return topic;
    }
}
