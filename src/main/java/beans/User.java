package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped 
public class User {
	@NotNull() @Size(min=5, max=15)
	private String firstName;
	@NotNull() @Size(min=5, max=15)
	private String lastName;

	public User()
	{
        this.firstName = "Johnnie";
        this.lastName = "DoeRay";
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
