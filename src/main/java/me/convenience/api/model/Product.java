package me.convenience.api.model;


/**
 * 
 * @author jsreevalsan
 *
 */
public class Product {

	
	private String name ; 

	private String description ;

	private String imageURL ;
	
	private Integer status;
	
	private Alert alert;

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	} 
	
	
	
	
	
}
