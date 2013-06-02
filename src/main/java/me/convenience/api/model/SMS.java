package me.convenience.api.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author jsreevalsan
 *
 */
public class SMS {

	@NotBlank
	@Length(max = 160)
	private String smsText ; 
	
	@NotBlank
	private String phoneNumber ;
	
	
	private String smsSid ;
	private String accountSid ;
	private String from ;
	private String to ;
	private String body ;

	public String getSmsText() {
		return smsText;
	}

	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSmsSid() {
		return smsSid;
	}

	public void setSmsSid(String smsSid) {
		this.smsSid = smsSid;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
}
