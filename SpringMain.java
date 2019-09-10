package assignment.spring23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		MailUtility mu = (MailUtility)context.getBean("mailutil");
		SendMail sm = (SendMail)context.getBean("sendmail");
		String message = "This is a message";
		String subject = "Assignment23";
		String[] strArray = {"zsebastian08@gmail.com"};


		sm.sendMailPlz(sm.getConfig().config(), message, subject, strArray);

	}

}
