package me.convenience.api.model.provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import me.convenience.api.model.DashBoard;
import me.convenience.api.model.Product;
import me.convenience.api.model.UserProfile;

import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionProvide {

	private DataSource ds;
	 
 
	public SubscriptionProvide() {
	}

	public  DashBoard getDashboard(String userId){
		
		DashBoard board = new DashBoard() ;
		Statement stmt = null;
		Connection con;
		try {
			Context ctx = new InitialContext();

			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/conv");


			con = ds.getConnection();
		} catch (SQLException | NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null ;
		}
		try {
			
			List<Product> products = new ArrayList<Product>();
			UserProfile up = new UserProfile() ;
			
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * from subscription where userid=\""+userId+"\"";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				
				Product p1 = new Product();
				up.setName(rs.getString("userName"));
				
				
				up.setImageURL("http://convenience.cloudapp.net/con-1.0/resources/images/user_images/"+ rs.getString("userimageURL")) ;		
				
				up.setGuestSince( rs.getString("guestSince"));
				
				p1.setName( rs.getString("name")) ;
				p1.setDescription( rs.getString("description"));
				p1.setImageURL("http://convenience.cloudapp.net/con-1.0/resources/images/product_images/"+  rs.getString("imageURL"));
				p1.setStatus(rs.getInt("status"));
				
				
				// Display values 
				products.add(p1);
				board.setUserProfile(up);
				
			}
			board.setProducts(products);
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();

			
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(con!=null)
		        	 con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return board ;
	}
}
