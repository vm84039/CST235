package data;

import java.util.List;
import javax.ejb.Stateless;
import beans.OrderBean.Order;



@Stateless
public interface DataAccessInterface {
	public List<Order> findAll();

}
