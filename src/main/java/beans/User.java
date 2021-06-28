package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class User {

	private String firstName;
	private String lastName;

	@PostConstruct
	public void init() {
	// Get the logged in Principle
	Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(principle == null)
		{
			setFirstName("Unknown");
			setLastName("");
		}
		else
		{
			setFirstName(principle.getName());
			setLastName("");
		}
	}

	public User()
	{
        this.firstName = "";
        this.lastName = "";
	}
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
