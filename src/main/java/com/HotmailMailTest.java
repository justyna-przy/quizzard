package com;
import com.Classes.Stats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
        import javax.mail.*;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;



public class HotmailMailTest {
    private String theirEmailAddress;


    // Trigger the login and check process


    public HotmailMailTest(String theirEmailAddress) {
        this.theirEmailAddress = theirEmailAddress;
    }

    public static void emailSend(String currentUserEmail) {


        Stats stats = new Stats();
        double userMean = stats.getUserMean();
        double userMedian = stats.getUserMedian();
        double userSD = stats.getUserSD();


              // Mail server properties for Hotmail (Outlook.com)
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        // Debugging information
        properties.put("mail.debug", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("quizzardverify@hotmail.com", "Ljubljana1112#");
            }
        });

        try {
            // Create a new MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress("quizzardverify@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(currentUserEmail));

            // Set the subject and text of the email
            message.setSubject("Quizzard Email Verification & Statistics");
            message.setText("Your mean score is " + userMean + "\nYour median score is " + userMedian + "\nYour Standard Deviation is " + userSD);

            // Send the message
            Transport.send(message);
            System.out.println("----------MAIL SENT-----------");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


