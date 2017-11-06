package view;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

@Named
public class RegisterMb implements Serializable {

	private static final long serialVersionUID = -2107638903454277960L;

	@Inject
	private UserController userCntr;

	private String email;
	private String password;
	private String name;

	public String register() {

		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setIs_admin(0);
		userCntr.register(user);

		return "index";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
