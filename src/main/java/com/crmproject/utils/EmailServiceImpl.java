package com.crmproject.utils;

import com.crmproject.models.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Value("ramdeennishadraj273209@gmail.com")
    private String sender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendEmail(Email email) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getTo());
            mailMessage.setText(email.getBody());
            mailMessage.setSubject(email.getSubject());
            //sending email
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            return "Error occurred while sending email: " + e.getMessage();
        }

    }
}