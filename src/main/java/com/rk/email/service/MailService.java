package com.rk.email.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.rk.email.model.Email;
/**
 * 
 * @author Ravi Baghel
 *
 */
@Service
public interface MailService {

	public void sendEmail(Email email) throws MailException;

	public void sendEmailWithAttachment(Email email) throws MailException, MessagingException;

}