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

        //store the score in the csv row belonging to the user currently logged in
        FileWriter fw3 = new FileWriter("src/main/resources/stats.csv", true);

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stats.csv"));
        String line;


        //adds all the usernames from the stats.csv to wordsInFirstColumn
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0) {
                String usernameInStorage = parts[0].trim();
                wordsInFirstColumn.add(usernameInStorage);
            }

            //checks if current username matches any username stored in wordsInFirstColumn
            //if it matches it stores the users score at the end of the line
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
