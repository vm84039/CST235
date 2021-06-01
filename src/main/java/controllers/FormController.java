package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Orders;
import beans.User;

@ManagedBean
@ViewScoped 
public class FormController {
	public String onSubmit(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	public String onFlash(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRequestMap().put("user", user);
		context.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}
