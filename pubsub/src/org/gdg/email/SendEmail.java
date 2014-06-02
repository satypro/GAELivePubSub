package org.gdg.email;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;


public class SendEmail {
	
    private static final Logger log = Logger.getLogger(SendEmail.class.getName());
	
    public static void Send(Message message){
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			
			log.log(Level.SEVERE,"Error in sending email , Error Message:"+e.getMessage());
		}
	}
}
