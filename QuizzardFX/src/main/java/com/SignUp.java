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
    private PasswordField confirmpass;

    @FXML
    private Label errorMessage;





        public void checkPassword() throws IOException{
            String usernm = username.getText().toString();
            String pass = password.getText().toString(); //takes user inputted text from text box and stores it in String username
            String confirm = confirmpass.getText().toString();


            if(pass.equals(confirm)){
                writeSignup(usernm, pass);
                Main n = new Main();
                n.changeScene("/login.fxml");


            }else{
                errorMessage.setText("Passwords do not match!");
            }
        }





        public void writeSignup(String username, String password) {
            try {
                FileWriter fw = new FileWriter("login.txt", true);
                fw.write(username+ "\t" + password + "\n"); //typed username and password will be written to login.txt
                    // "\n" writes the next data to new line
                fw.close();

            }catch (Exception e){}
        }









}
