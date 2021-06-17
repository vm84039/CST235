package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import beans.OrderBean.Order;




@Stateless
@LocalBean
public class OrdersDataService implements DataAccessInterface {
	
	@Override
	public List<Order> findAll() {
		String url = "jdbc:mysql://localhost:3306/testapp";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		List<Order> orders = new ArrayList<Order>(); 
		
		System.out.println("Find All method");
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM testapp.orders";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
		    	  Order order = new Order();;
		          order.setID(result.getInt("ID"));
		          order.setProductName(result.getString("PRODUCT_NAME"));
		          order.setPrice(result.getFloat("PRICE"));
		          order.setQuantity(result.getInt("QUANTITY"));
		          orders.add(order);
		       }
		    result.close();
		    statement.close();conn.close();
		    System.out.println(orders.toString());
		    

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}

		return orders;
	}

}
