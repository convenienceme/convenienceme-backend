package me.convenience.api.model;

import java.io.Serializable;

/**
 * 
 * @author jsreevalsan
 *
 */
 
public class Alert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	private String alertId; 
	
	private String alertString ;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getAlertString() {
		return alertString;
	}

	public void setAlertString(String alertString) {
		this.alertString = alertString;
	}
	
	
}
