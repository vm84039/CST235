package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import beans.OrderBean.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean

public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	/**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        
        orders.add(new Order("1","burger",5, 2)); 
        orders.add(new Order("2","fries", 3, 4));
        orders.add(new Order("3","Coke", (float) 2.5, 2)); 
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
		
	}

}
