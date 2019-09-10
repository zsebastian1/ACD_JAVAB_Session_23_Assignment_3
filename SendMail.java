package assignment.spring23;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	private String from;
	private String to;
	private String message;
	private String subject;
	private MailUtility config;
	
	public MailUtility getConfig() {
		return config;
	}
	public void setConfig(MailUtility config) {
		this.config = config;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public SendMail(String from, MailUtility config) {
		super();
		this.from = from;
		this.config = config;
	}
	
	public SendMail() {
		
	}
	
	public void sendMailPlz(Session session, String message, String subject, String[] to) {
		
		try {
			 for(String str: to) {
				 System.out.println(str);
				 Message msg = new MimeMessage(session);
				 msg.setSubject(subject);
				 msg.setText(message);
				 msg.setRecipients(Message.RecipientType.TO,
                         InternetAddress.parse(str));			 
				Transport.send(msg);
				
				
			 }
		}
	catch(Exception e) {
	e.printStackTrace();
	}
}

}