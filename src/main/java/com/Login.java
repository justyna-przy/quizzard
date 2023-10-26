package com;
import java.io.FileReader;
import java.io.BufferedReader;

import com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Login{
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




    public void userLogin(ActionEvent event) throws IOException
    {
        checkLogin();
    }

    public void userSignIn(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("/signin.fxml");
    }

    private void checkLogin() throws IOException{


        boolean matched = false;
        String usernameStr = username.getText().toString(); //takes user inputted text from text box and stores it in String username
        String passwordStr = password.getText().toString();

        try{

            FileReader fr = new FileReader("login.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){ //reads all the lines up until they become null
                if(line.equals(usernameStr + "\t" + passwordStr)){ //if the read line matches the user and password
                    matched = true;
                    break;
                }
            }
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }





        if(matched){
            Main m = new Main();
            m.changeScene("/quiz.fxml");


        }else{
            errorMessage.setText("Sorry, Incorrect username or password");
        }

        //add else if for empty password field and text field

    }


}




