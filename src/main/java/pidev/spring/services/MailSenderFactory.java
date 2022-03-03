package pidev.spring.services;

public interface MailSenderFactory {
	public void sendSimpleEmail(String toAddress, String subject, String message);
}
