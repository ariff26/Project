package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    // Always send mail to admin
    public void sendEnrollmentEmailToAdmin(String name, String email, String course) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ms.ariff26@gmail.com"); // must match spring.mail.username
        message.setTo("ariffips25@gmail.com");       // <-- Admin Email here
        message.setSubject("New Enrollment Received");
        message.setText(
                "A new student has enrolled.\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Course: " + course + "\n\n" +
                        "Please check the database for more details."
        );

        mailSender.send(message);
    }

}
