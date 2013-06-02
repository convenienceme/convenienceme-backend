package me.convenience.api.model;

import java.util.List;
 
/**
 * 
 * @author jsreevalsan
 *
 */

public class DashBoard {

	
	private UserProfile userProfile ;
	
	
	private List<Product> products;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	} 
	
	
	
}
