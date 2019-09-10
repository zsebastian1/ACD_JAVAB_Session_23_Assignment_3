package assignment.spring23;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.mysql.cj.xdevapi.SessionFactory;

public class MailUtility {

	private String host;
	private String username;
	private String password;
	private String auth;
	private String port;
	private Properties prop = new Properties();
	private Session session;
	
	public MailUtility() {}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "MailUtility [host=" + host + ", username=" + username + ", password=" + password + ", auth=" + auth
				+ ", port=" + port + "]";
	}
	

	
	public MailUtility(String host, String username, String password, String port) {
		super();
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
		
		config();
	}

	public Session config() {
		prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);

		session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(username, password);
                   }
                });
		return session;
	}
	
	
	
}
