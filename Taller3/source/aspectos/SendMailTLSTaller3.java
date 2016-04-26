package aspectos;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLSTaller3 {

	// Descargar librería https://java.net/projects/javamail/pages/Home
	// Agregarla al proyecto
	final String username = "test@sinerware.com";
	final String password = "S1nertest";
	Session session;

	public static void main(String[] args) {
		SendMailTLSTaller3 sendMailTLSTaller3 = new SendMailTLSTaller3();
		sendMailTLSTaller3.send("prueba taller3");
	}

	SendMailTLSTaller3() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.sinerware.com");
		props.put("mail.smtp.port", "587");

		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public void send(String msg) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("test@sinerware.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("alejotroncoso@gmail.com"));
			message.setSubject("Notificación taller3");
			message.setText(msg);
			Transport.send(message);
			System.out.println("Se envió correo");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}