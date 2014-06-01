package org.gdg.publisher;

public class Message {

	String  sendTo;
	String  subject;
	String  message;
	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSubjet() {
		return subject;
	}
	public void setSubjet(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
