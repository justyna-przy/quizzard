package com.Classes;

import com.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*
    This class handles and stores the scores
 */

public class ScoreHandler {
    private static int storedScore = 0;

    public static void setScore(int score) throws IOException {

        List<String> wordsInFirstColumn = new ArrayList<>();

        storedScore = score;
        FileWriter fw3 = new FileWriter("src/main/resources/stats.csv", true);

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stats.csv"));
        String line;


        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0) {
                String usernameInStorage = parts[0].trim(); // Assign value to 'usernameInStorage'
                wordsInFirstColumn.add(usernameInStorage);
            }

            for (String word : wordsInFirstColumn) {
                if (word.equals(Main.getCurrentUser().getUsername())) {
                    fw3.write(storedScore + ",");
                    break;
                }
            }
        }
        fw3.close();

    }

    public static int getScore() {
        return storedScore;
    }

}
