package com.taskStudio.taskStudio.Services;


import com.taskStudio.taskStudio.ServiceInterface.EmailServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;


@Service
public class EmailService implements EmailServiceInterface {

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String to, String subject, String message) throws MailException {

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setText(message);
            mail.setSubject(subject);

            for(int i=0;i<10000;i++){
                Thread.sleep(700);
                javaMailSender.send(mail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
