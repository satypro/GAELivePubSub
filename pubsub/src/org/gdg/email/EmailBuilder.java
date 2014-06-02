package org.gdg.email;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.google.appengine.api.datastore.Email;

public class EmailBuilder {

	private static final Logger log = Logger.getLogger(EmailBuilder.class.getName());
    private Message emailMessage;
    private Multipart multiPart;
    
    
	public EmailBuilder() {
		
		Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);
		emailMessage = new MimeMessage(session);
	    multiPart = new MimeMultipart();

    }
	
	public Message getEmailMessage() {
		           
		return emailMessage;
		
	}
	
	/**
	 * 
	 * @param toEmail to email id
	 * @param name    to email name
	 * @return
	 */
	public EmailBuilder build(String toEmail, String name)
	{	
		try {
			emailMessage.addRecipient(Message.RecipientType.TO,
			        new InternetAddress(toEmail,name));
		} catch (UnsupportedEncodingException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (MessagingException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		return this;	
	}
	
	/**
	 * 
	 * @param fromEmail  from email id 
	 * @param name       from email name
	 * @param subject    email subject
	 * @return
	 */
	public EmailBuilder build(String fromEmail,String name,String subject){
		
		try {
			emailMessage.setFrom(new InternetAddress(fromEmail, name));
			emailMessage.setSubject(subject);
		} catch (UnsupportedEncodingException e) {
			log.log(Level.SEVERE,e.getMessage());
		} catch (MessagingException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		
		return this;
	}
	
     /**
      * 
      * @param body         the body in html if the content type is "text/html"
      * @param contentType  content type for example "text/html"
      * @param b            just a parameter deprecated
      * @return
      */
	public EmailBuilder build(String body, String contentType,int b){

	        MimeBodyPart htmlPart = new MimeBodyPart();
	        try {
				htmlPart.setContent(body,contentType );
				multiPart.addBodyPart(htmlPart);
			    emailMessage.setContent(multiPart);
			} catch (MessagingException e) {
			log.log(Level.SEVERE,e.getMessage());
			}
	        
	        
		return this;
	}
	
	/**
	 * 
	 * @param attachmentfile  attachment file name
	 * @param attachmentData  attachment data in byte[] array 
	 * @param type            attachment type for example type = "application/pdf"
	 * @return
	 */
	public EmailBuilder build(String attachmentfile,byte[] attachmentData,String type)
	{
		MimeBodyPart attachment = new MimeBodyPart();
        try {
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentData, type);
		    multiPart.addBodyPart(attachment);
		    emailMessage.setContent(multiPart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return this;
	}
}
