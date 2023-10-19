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

        }





        if(matched){
            errorMessage.setText("Welcome");


        }else{
            errorMessage.setText("Sorry, Incorrect username or password");
        }

        //add else if for empty password field and text field

    }


}
    /* TextField t1, t2;
    Button b1, b2;

    Text l2;


    public Login(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Login");
        b2 = new JButton("Sign up");
        l1 = new JLabel("Login");

        l1.setFont(new Font("Comic Sans", Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,10,300,50);
        add(l1);


        t1.setBounds(100, 60,120, 30);
        t2.setBounds(100, 100,120, 30);
        b1.setBounds(120, 140,80,30); //button for login
        b2.setBounds(120, 170 , 80 ,30); //button for signup

        l2 = new JLabel("");
        l2.setBounds(250, 80, 300, 30);
        add(l2);

        add(t1);
        add(t2);
        add(b1);
        add(b2);

         */

       /* b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                boolean matched = false;
                String username = t1.getText().toString(); //takes user inputted text from text box and stores it in String username
                String password = t2.getText().toString();

                try{

                    FileReader fr =new FileReader("login.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while((line = br.readLine()) != null){ //reads all the lines up until they become null
                        if(line.equals(username + "\t" + password)){ //if the read line matches the user and password
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                }catch (Exception e){

                }



                if(matched){
                    l2.setText("Welcome");
                    dispose(); //will get rid of the login GUI
                    // yt man also calls another object here
                    //call quiz menu class here
                }else{
                    l2.setText("Invalid username or password");
                }

                /* if(t1.getText().toString().equals("admin") && t2.getText().toString().equals("password")){
                    l2.setText("Welcome");
                    //dispose(); will get rid of the login GUI
                }else{
                    l2.setText("Invalid username or password");
                } */

        /*});

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(200, 200, 500, 300);

            }
        });



    }

         */

