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

import me.convenience.api.model.Alert;

import org.springframework.stereotype.Repository;

@Repository
public class AlertProvider {

	private DataSource ds;
	
	private List<Alert> alerts = new ArrayList<>() ;
	
 
	
	public AlertProvider() {
	}

	public  List<Alert> getAlerts(){
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
					stmt = con.createStatement();
			String sql;
			sql = "SELECT * from alerts";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				
				Alert a = new Alert() ;
				
				// Retrieve by column name
				a.setAlertId(rs.getString("alertId"));
				a.setAlertString(rs.getString("alertString")); 
				// Display values 
				
				alerts.add(a);
			}
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
		return alerts ;
	}
}
