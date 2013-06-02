package me.convenience.api.model.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.convenience.api.model.SMS;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;


/**
 * 
 * @author jsreevalsan
 *
 */
public class SMSProvider {

  	public static final String ACCOUNT_SID = "ACa48f7bcbe0a5405b9188f8de5ab5690a";
	public static final String AUTH_TOKEN = "ec77b7c2b613360c546c6dab43a64313";
	
	public static final String FROM_NO ="+13302672638" ;

	public void postSMS(SMS sms) throws IOException, TwilioRestException {


	    // Create a rest client
	    final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);


	    // Get the main account (The one we used to authenticate the client)
	    final Account mainAccount = client.getAccount();
	    
	    // Send an sms
	    final SmsFactory smsFactory = mainAccount.getSmsFactory();
	    final Map<String, String> smsParams = new HashMap<String, String>();
	    smsParams.put("To", sms.getPhoneNumber()); // Replace with a valid phone number
	    smsParams.put("From", FROM_NO); // Replace with a valid phone number in your account
	    smsParams.put("Body", sms.getSmsText());
	    smsFactory.create(smsParams);

	}

}
