package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.OrderBean.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative

public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        
        Order order = new Order();
       //(String orderNumber, String productName, float price, int quantity
        order.setOrderNumber("1");order.setProductName("Pencils");order.setPrice((float) .25); order.setQuantity(100);
        orders.add(order);
        order = new Order();
        order.setOrderNumber("2");order.setProductName("Paper");order.setPrice((float) .10); order.setQuantity(500);
        orders.add(order);
        order = new Order();
        order.setOrderNumber("3");order.setProductName("Markers");order.setPrice((float) 1); order.setQuantity(25);
        orders.add(order);  
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello from the AnotherOrdersBusinessService");
    }
	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
}}
