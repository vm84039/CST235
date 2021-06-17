package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.OrderBean.Order;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative


public class OrdersBusinessService implements OrdersBusinessInterface {
	
	@Inject
	OrdersDataService service;
	List<Order> orders;
	/**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	
    	orders = new ArrayList<Order>();
    	
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		return service.findAll();
	}

	@Override
	public void setOrders(List<Order> orders) {

		
	}

}