package com;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class SignUp extends JFrame {
    public void signIn(ActionEvent event) throws IOException{
        checkPassword();
    }


   @FXML
    private Button signupButton;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private TextField email;

    @FXML
    private PasswordField confirmpass;

    @FXML
    private Label errorMessage;





        public void checkPassword() throws IOException{
            String usernm = username.getText().toString();
            String pass = password.getText().toString();
            String enteredEmail = email.getText().toString();

            String confirm = confirmpass.getText().toString();


            if (pass.equals(confirm) && pass.length() < 30) {

                if (!isUsernameTaken(usernm)) {

                    writeSignup(usernm, pass, enteredEmail);
                    Main n = new Main();
                    n.changeScene("/login.fxml", null, null, null);

                } else {
                    errorMessage.setText("Username already taken. Please choose a different username.");
                }
            } else {
                errorMessage.setText("Passwords do not match!");
            }
        }

    private boolean isUsernameTaken(String username) throws IOException {
        FileReader fr = new FileReader("src/main/resources/login.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");


            if (parts.length == 3 && parts[0].equals(username)) {
                fr.close();
                return true; // Username already exists sadly
            }
        }
        fr.close();
        return false; // Username is available
    }




    public void writeSignup(String username, String password, String enteredEmail) {
        List<String> wordsInFirstColumn = new ArrayList<>();

        if ((username.length() > 0) && (password.length() > 0)&& (enteredEmail.length() > 0 && (username.length() < 30) && (password.length() < 30)&& (enteredEmail.length() < 30) )) {
            try {
                FileWriter fw = new FileWriter("src/main/resources/login.txt", true);
                fw.write("\n" + username + "\t" + password + "\t" + enteredEmail); //typed username and password will be written to login.txt
                // "\n" writes the next data to new line
                fw.close();

                //writing to STATS.CSV
                FileWriter fw2 = new FileWriter("src/main/resources/stats.csv", true);
                fw2.write("\n" + username + ","); //typed username and password will be written to stats.csv

                fw2.close();


            } catch (Exception e) {
            }
        }
    }


}
