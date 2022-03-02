package pidev.spring.services;

public interface TwillioService {
	
	
	void sendSms(String to, String from, String body);

	void makeCall(String from, String to);


}
