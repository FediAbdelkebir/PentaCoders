package pidev.spring.services;

import org.springframework.beans.factory.annotation.Value;

import com.twilio.Twilio;

import pidev.spring.entities.Message;



public class ImplTwillioService implements TwillioService {

	@Value("${app.twillio.accountSID}")
	private String ACCOUNT_SID;
	
	@Value("${app.twillio.authToken}")
	private String AUTH_TOKEN;
	
	@Override
	public void sendSms(String to, String from, String body) {
		
				
			}

	@Override
	public void makeCall(String from, String to) {
		// TODO Auto-generated method stub
		
	}

}
