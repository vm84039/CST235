package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")

public class OrdersRestService {

	@Inject
	OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson()
	{
		return service.getOrders();
	}
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public  Order[] getOrdersAsXml()
	{
		List<Order> list = new ArrayList<Order>();
		list = service.getOrders();
		Order[] array = new Order[list.size()];
		list.toArray(array);
		System.out.println("XML : " + Arrays.toString(array));
		return array;
	}

	
	
}
