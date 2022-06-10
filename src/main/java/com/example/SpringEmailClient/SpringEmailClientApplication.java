package com.example.SpringEmailClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		/*emailSenderService.sendSimpleEmail("manivel.svm@gmail.com",
				"This is the Email Body...",
				"This is mz Subject"
				);*/
		emailSenderService.sendEmailWithAttachemet("manivel.svm@gmail.com",
				"Email With Attachment..",
				"Email With Attachment..",
				"D:\\Aayush\\Germany Pics\\Aayush.jpeg");

	}

}
