
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;

import business.OrdersBusinessInterface;
import business.OrdersBusinessService;

@ManagedBean(name="order")
@ViewScoped 

public class OrderBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private  List<Order> orders = new ArrayList<Order>();
    @Inject
    private OrdersBusinessInterface service = new OrdersBusinessService(); 
    
    
    @PostConstruct 
    public void init()
    {
 
    	this.orders = service.getOrders();
    }
    
    public List<Order> getOrders() {
    	 
    	return orders;

    }  


}