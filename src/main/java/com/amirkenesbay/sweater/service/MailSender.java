package com.amirkenesbay.sweater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
// https://www.youtube.com/watch?v=yBXs_gtSmUc&list=PLU2ftbIeotGoGSEUf54LQH-DgiQPF2XRO&index=9
// 6:15
@Service
public class MailSender {
    private final JavaMailSender mailSender;

    @Value("{spring.mail.username}")
    private String username;

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String emailTo, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
