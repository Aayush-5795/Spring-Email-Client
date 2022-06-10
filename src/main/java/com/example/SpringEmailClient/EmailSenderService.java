package com.example.SpringEmailClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom("aayushs.pandit01@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("Mail Send... Congratulations");
    }

    public void sendEmailWithAttachemet(String toEmail,
                                        String subject,
                                        String body,
                                        String attachement) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom("aayushs.pandit01@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource =
                new FileSystemResource(new File(attachement));

        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
                fileSystemResource);

        javaMailSender.send(message);
        System.out.println("Mail Send... Congratulations");


    }
}
