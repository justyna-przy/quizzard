package com;

import java.io.FileReader;
import java.io.BufferedReader;

import com.Classes.CurrentUser;
import com.Classes.QuizModel;
import com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * The Login class manages user authentication and controls the login UI elements.
 * It handles user input, checks login credentials, and initiates scene changes accordingly.
 */
public class Login {

    @FXML
    private Button loginButton;

    @FXML
    private Button signinButton;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorMessage;

    private String emailStr;

    // Represents the currently logged-in user.
    CurrentUser currentUser = new CurrentUser();

    /**
     * Triggered when the login button is pressed.
     * Calls the checkLogin method to authenticate the user.
     *
     * @param event The ActionEvent associated with the button press.
     * @throws IOException If an I/O error occurs during login processing.
     */
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    /**
     * Initiates the process of user sign-in by changing the scene to the sign-in view.
     *
     * @param event The ActionEvent associated with the button press.
     * @throws IOException If an I/O error occurs during scene transition.
     */
    public void userSignIn(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/signin.fxml", null, null, null);
    }

    /**
     * Validates user login credentials by checking against the data in the login database.
     * If credentials are valid, updates the current user information and transitions to the home view.
     *
     * @throws IOException If an I/O error occurs during login credential verification.
     */
    private void checkLogin() throws IOException {
        boolean matched = false;
        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();

        if ((usernameStr.length() > 0) && (passwordStr.length() > 0)) {
            try {
                FileReader fr = new FileReader("src/main/resources/login.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\t");

                    // Assuming the format is "username\tpassword\temail"
                    if (parts.length == 3 && parts[0].equals(usernameStr) && parts[1].equals(passwordStr)) {
                        currentUser.setUsername(usernameStr);
                        currentUser.setEmail(parts[2]);
                        matched = true;
                        break;
                    }
                }
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (matched) {
                Main.setCurrentUser(currentUser);

                Main m = new Main();
                m.changeScene("/home.fxml", null, null, null);
            } else {
                errorMessage.setText("Sorry, Incorrect username or password");
            }
        }
    }
}
