package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order") 
public class Order  implements Serializable{	
		private String orderNumber;
		private String productName;
		private float price;
		private int quantity;
		private int ID;
   
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		
		
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


