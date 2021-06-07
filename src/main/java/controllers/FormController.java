package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped 
public class FormController {
	
	@Inject
	OrdersBusinessInterface Test; 
	@Inject
	OrdersBusinessInterface service;
	@EJB
	MyTimerService timer;
	
	public String onSubmit(User user) 
	{
		timer.setTimer(10000);
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		Test.test();
		return "TestResponse.xhtml";
	}
	public String onFlash(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRequestMap().put("user", user);
		context.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	public OrdersBusinessInterface getService() {
		return service;
	}
}
