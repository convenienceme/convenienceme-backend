package me.convenience.api.model;


/**
 * 
 * @author jsreevalsan
 *
 */
public class UserProfile {

	
	private String name ; // Full Name
	
	private String phoneNumber ; // Phone Number.
	
	private String imageURL ; // URI to your 
	
	private String guestSince ; // Guest since 

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuestSince() {
		return guestSince;
	}

	public void setGuestSince(String guestSince) {
		this.guestSince = guestSince;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}



}
