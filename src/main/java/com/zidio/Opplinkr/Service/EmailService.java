package com.zidio.Opplinkr.Service;

import com.zidio.Opplinkr.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendMail(EmailRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(request.to);
        message.setSubject(request.subject);
        message.setFrom("harshp3577@gmail.com");
        message.setText(request.massage);

        mailSender.send(message);
        return "Email successfully sent.";
    }
}
