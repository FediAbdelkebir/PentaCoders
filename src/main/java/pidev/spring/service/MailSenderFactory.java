package pidev.spring.service;

public interface MailSenderFactory {
	public void sendSimpleEmail(String toAddress, String subject, String message);
}
