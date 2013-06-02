package me.convenience.api.model.provider;

import com.google.common.collect.Lists;

import me.convenience.api.model.DashBoard;
import me.convenience.api.model.Product;
import me.convenience.api.model.UserProfile;


/**
 * 
 * @author jsreevalsan
 *
 */
public class DashboardProvider {

	public DashBoard getDashboard(String userName, String context) { 

		DashBoard d = new DashBoard();

		Product p1 = new Product();

		p1.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting " +
				"industry. Lorem Ipsum has been the industry's standard dummy text ever since" +
				" the 1500s, when an unknown printer took a galley of type and scrambled it to " +
				"make a type specimen book. It has survived not only five centuries, but also " +
				"the leap into electronic typesetting, remaining essentially unchanged." +
				" It was popularised in the 1960s with the release of Letraset sheets " +
				"containing Lorem Ipsum passages, and more recently with desktop publishing" +
				" software like Aldus PageMaker including versions of Lorem Ipsum.");
		
		p1.setImageURL(context+"/resources/images/product_images/cheap_hairgel.jpg") ;
		p1.setName("Product 1") ;
		p1.setStatus(10);
		
		Product p2 = new Product();

		p2.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting " +
				"industry. Lorem Ipsum has been the industry's standard dummy text ever since" +
				" the 1500s, when an unknown printer took a galley of type and scrambled it to " +
				"make a type specimen book. It has survived not only five centuries, but also " +
				"the leap into electronic typesetting, remaining essentially unchanged." +
				" It was popularised in the 1960s with the release of Letraset sheets " +
				"containing Lorem Ipsum passages, and more recently with desktop publishing" +
				" software like Aldus PageMaker including versions of Lorem Ipsum.");
		
		p2.setImageURL(context+"/resources/images/product_images/dishwasher_soap_cheap.jpg") ;
		p2.setName("Product 2") ;
		p2.setStatus(90);
		
		UserProfile up = new UserProfile() ;
		up.setGuestSince("Guest since Jan 2013");
		up.setImageURL(context+"/resources/images/user_images/msutherland.jpg") ;		
		up.setName("johnny Depp");
		
		
		d.setProducts(Lists.newArrayList(p1, p2)) ;
		d.setUserProfile(up);
		
		return d;
	}

	 

}
