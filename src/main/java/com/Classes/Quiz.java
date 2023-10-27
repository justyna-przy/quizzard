package com.Classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Quiz {
    public static void Quizmethod() {
        try {
            String filePath = "C:/Users/Thoma/Downloads/k.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Scanner scanner = new Scanner(System.in);

            String line;
            int qno = 0;
            String[] questionz = new String[20];
            String[] answerz1 = new String[20];
            String[] answerz2 = new String[20];
            String[] answerz3 = new String[20];
            String[] answerz4 = new String[20];

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String question = parts[0].trim();
                    String ans1 = parts[1].trim();
                    String ans2 = parts[2].trim();
                    String ans3 = parts[3].trim();
                    String ans4 = parts[4].trim();
//revise
                    questionz[qno] = question;
                    answerz1[qno] = ans1;
                    answerz2[qno] = ans2;
                    answerz3[qno] = ans3;
                    answerz4[qno] = ans4;
                    qno++;
                }
            }
            reader.close();
            Random randomo = new Random();

            for (int i = qno - 1; i > 0; i--) {
                int randomIndex = randomo.nextInt(i + 1);
                String temp = questionz[i];
                questionz[i] = questionz[randomIndex];
                questionz[randomIndex] = temp;

                temp = answerz1[i];
                answerz1[i] = answerz1[randomIndex];
                answerz1[randomIndex] = temp;

                temp = answerz2[i];
                answerz2[i] = answerz2[randomIndex];
                answerz2[randomIndex] = temp;

                temp = answerz3[i];
                answerz3[i] = answerz3[randomIndex];
                answerz3[randomIndex] = temp;

                temp = answerz4[i];
                answerz4[i] = answerz4[randomIndex];
                answerz4[randomIndex] = temp;
            }
            List<Integer> shuffledIndices = new ArrayList<>();
            for (int i = 0; i < qno; i++) {
                shuffledIndices.add(i);
            }
            Collections.shuffle(shuffledIndices);

            int score = 0;
            for (int i = 0; i < qno; i++) {
                int randomIndex = shuffledIndices.get(i);
                System.out.println("QUESTION " + (i + 1));
                System.out.println(questionz[randomIndex]);

                List<String> qshuffle = new ArrayList<>();
                qshuffle.add(answerz1[randomIndex]);
                qshuffle.add(answerz2[randomIndex]);
                qshuffle.add(answerz3[randomIndex]);
                qshuffle.add(answerz4[randomIndex]);

                Collections.shuffle(qshuffle);
                for (String option : qshuffle) {
                    System.out.println(option);
                }

                System.out.print("Your answer: ");
                String userAnswer = scanner.next();

                if (userAnswer.equalsIgnoreCase(answerz1[randomIndex])) {

                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong!\n" + "The correct answer was -" + answerz1[randomIndex] + "-");
                }
            }
            scanner.close();

            System.out.println("Quiz complete. Your score: " + score + " from " + qno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
