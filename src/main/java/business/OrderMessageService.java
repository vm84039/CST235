package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")

public class OrderMessageService implements MessageListener {

	@EJB
	OrdersDataService service;
	Order send;
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message)  {
    	if (message instanceof Message) {
            try {
        		ObjectMessage objectMessage = (ObjectMessage) message;
        		send = new Order();
        		send = (Order)objectMessage.getObject();
        		service.send(send);
        		System.out.println("ON Message method:  "+ send.getOrderNumber());
            	
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }};
    /*    else 
        {
        	try {
        		ObjectMessage objectMessage = (ObjectMessage) message;
        		send = new Order();
        		send = (Order)objectMessage.getObject();
        		service.send(send);
        		System.out.println("ON Message method:  "+ send.getOrderNumber());
        		
        	}
        	catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }};*/
        }
        
    

}
