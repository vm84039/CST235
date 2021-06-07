package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="order")
@ViewScoped 

public class OrderBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final Order[] orders = new Order[] {
		new Order("1","burger",5, 2),
		new Order("2","fries", 3, 4),
		new Order("3","Coke", (float) 2.5, 2)   
    };
    
    public Order[] getOrders() {
    	 
        return orders;

    }  

public static class Order {
	
	private String orderNumber;
	private String productName;
	private float price;
	private int quantity;
	
	public Order()
	{
		this.orderNumber = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
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
