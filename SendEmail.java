import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmail {
	public static void main(String[] args) {
		// change accordingly
		String to = "veera@yopmail.com";

		// change accordingly
		String from = "admin@deelchat.com";

		// or IP address
		String host = "*******";

		// mail id
		final String username = "admin@admin.com";

		// correct password for gmail id
		final String password = "******!";

		System.out.println("TLSEmail Start");
		// Get the session object

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.ssl.trust", host);

		// SSL Port
		properties.put("mail.smtp.port", "587");

		// enable authentication
		properties.put("mail.smtp.auth", "true");
		
		
//		properties.put("mail.smtp.socketFactory.port", "465");

		// SSL Factory
		//properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// creating Session instance referenced to
		// Authenticator object to pass in
		// Session.getInstance argument
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

			// override the getPasswordAuthentication
			// method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try

		{

			// javax.mail.internet.MimeMessage class is mostly
			// used for abstraction.
			MimeMessage message = new MimeMessage(session);

			// header field of the header.
			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("subject");
			message.setText("Hello, Testing this is sending email ");

			// Send message
			Transport.send(message);
			System.out.println("Yo it has been sent..");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
