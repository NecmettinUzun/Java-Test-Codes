package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	class MailParams {

		private String body = "Test";
		private String subject = "Test";

		private String host;
		private String user;
		private String pass;
		private String[] toAdds = new String[1];

		public MailParams(String[] mailParams) {
			host = mailParams[0];
			user = mailParams[1];
			pass = mailParams[2];
			toAdds[0] = mailParams[3];
		}

		public String getHost() {
			return host;
		}

		public String getUser() {
			return user;
		}

		public String getPass() {
			return pass;
		}

		public String[] getToAdds() {
			return toAdds;
		}

		public String getBody() {
			return body;
		}

		public String getSubject() {
			return subject;
		}

	}

	private final static String MAIL_HOST_STR = "mail.smtp.host";
	private final static String MAIL_TLS_ENABLED_STR = "mail.smtp.starttls.enable";
	private static Session mailSession;

	public static void main(String[] args) {

		System.out.println("Sending E-Mail...");

		MailParams mailParams = new MailSender().new MailParams(args);

		initialize(mailParams);

		sendNotification(mailParams);
	}

	public static void initialize(MailParams mailParams) {

		Properties notificationProperties = new Properties();

		try {

			notificationProperties.put(MAIL_TLS_ENABLED_STR, "true");
			notificationProperties.put(MAIL_HOST_STR, mailParams.getHost());

		} catch (Exception e) {
			e.printStackTrace();
		}

		mailSession = Session.getDefaultInstance(notificationProperties, null);
		mailSession.setDebug(true);
	}

	public static boolean sendNotification(MailParams mailParams) {

		Transport trans = null;
		MimeMessage msg = new MimeMessage(mailSession);
		boolean sentMailSuccessful = false;
		try {

			msg.setFrom(new InternetAddress(mailParams.getUser()));
			InternetAddress[] toAdress = new InternetAddress[mailParams.getToAdds().length];
			for (int i = 0; i < toAdress.length; i++) {
				toAdress[i] = new InternetAddress(mailParams.getToAdds()[i]);
			}

			for (int i = 0; i < toAdress.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, toAdress[i]);
			}

			msg.setSubject(mailParams.getSubject());
			msg.setText(mailParams.body);
			msg.setSentDate(new Date());

			msg.saveChanges();

			trans = mailSession.getTransport(msg.getAllRecipients()[0]);

			trans.connect();
			trans.sendMessage(msg, msg.getAllRecipients());
			sentMailSuccessful = true;
		} catch (Exception e) {
			System.out.println("" + e);
			sentMailSuccessful = false;
		}

		return sentMailSuccessful;
	}
}
