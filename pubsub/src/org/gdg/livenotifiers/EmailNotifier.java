package org.gdg.livenotifiers;

import org.gdg.email.EmailBuilder;
import org.gdg.email.SendEmail;
import org.gdg.publisher.Message;

public class EmailNotifier {

	public static void sendUpdate(Message message,String from)
	{
	   EmailBuilder emailBuilder = new EmailBuilder();
	   emailBuilder.build(message.getSendTo(), "")
	               .build(from, from, message.getSubjet())
	               .build(message.getMessage(),"text/html",0)
	               .getEmailMessage();
	   
	   SendEmail.Send(emailBuilder.getEmailMessage());  
	}

}
