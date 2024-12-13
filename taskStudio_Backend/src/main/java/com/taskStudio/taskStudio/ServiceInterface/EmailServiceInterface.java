package com.taskStudio.taskStudio.ServiceInterface;

import org.springframework.mail.MailException;

public interface EmailServiceInterface {

    public void sendEmail(String to, String subject, String message) throws MailException;

}
