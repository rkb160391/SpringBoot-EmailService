package com.rk.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rk.email.model.Email;
import com.rk.email.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 * 
 * @author Ravi Baghel
 *
 */
@RestController
public class EmailController {

	@Qualifier(value = "mailServiceImpl")
	@Autowired
	private MailService mailService;

	@PostMapping(value = "send-mail")
	public String send(@RequestBody Email email) {
		System.out.println("email :" + email.toString());
		try {
			mailService.sendEmail(email);
			return "Congratulations! Your mail has been sent to the user.";
		} catch (MailException mailException) {
			System.out.println(mailException);
			return mailException.toString();
		}

	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 */
	@PostMapping(value = "send-mail-attachment")
	public String sendWithAttachment(@RequestBody Email email) throws MessagingException {

		try {
			mailService.sendEmailWithAttachment(email);
			return "Congratulations! Your mail has been sent to the user.";
		} catch (MailException mailException) {
			System.out.println(mailException);
			return mailException.toString();
		}

	}
}