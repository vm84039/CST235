
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.OrdersBusinessInterface;
import business.OrdersBusinessService;

@ManagedBean(name="order")
@ViewScoped 

public class OrderBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private  List<Order> orders = new ArrayList<Order>();
    @Inject
    OrdersBusinessInterface service = new OrdersBusinessService(); 
    
    
    @PostConstruct 
    public void init()
    {
 
    	this.orders = service.getOrders();
    }
    
    public List<Order> getOrders() {
    	 
    	return orders;

    }  

public static class Order {
	
	private String orderNumber;
	private String productName;
	private float price;
	private int quantity;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private int ID;
	
	public Order()
	{
		this.orderNumber = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
		this.ID = 0;
	}
	public Order(String orderNumber, String productName, float price, int quantity) {
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	}
}