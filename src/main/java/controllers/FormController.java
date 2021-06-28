package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped 
@Stateless

public class FormController {
	
	@Inject
	OrdersBusinessInterface Test; 
	@Inject
	OrdersBusinessInterface service;
//	@EJB
//	MyTimerService timer;
	
	public String onLogoff() 
	{
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";

	}
	public String onFlash(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRequestMap().put("user", user);
		context.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	public String onSend() {
		
		Order test = new Order("1","Burger", (float) 5.00, 2);
		test.setID(1);
		service.sendOrder(test);
		return "OrderResponse.xhtml";
	}
	public OrdersBusinessInterface getService() {

		return service;
	}
	private void getAllOrders(){
		String url = "jdbc:mysql://localhost:3306/testapp";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM testapp.orders";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  System.out.print("ID: "+result.getInt("ID")+", ");
		          System.out.print("Product Name: "+result.getString("PRODUCT_NAME")+", ");
		          System.out.print("Price: "+result.getFloat("PRICE"));
		          System.out.println();
		       }
		    result.close();
		    statement.close();conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		finally {
			
		}

	}
	private void insertOrder() {
		String url = "jdbc:mysql://localhost:3306/testapp";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String update = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) "
					+ "VALUES('001122334455', 'This was inserted new', 25.00, 100)";

			Statement statement = conn.createStatement();
			statement.executeUpdate(update);
			statement.close();conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}

	}
}
