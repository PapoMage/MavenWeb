package view;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

		if (name.length() < 3) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El username debe ser mayor a 3 caracteres" + name + password + email, null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "#";
		}
		if (password.length() < 8) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La contrasenia debe ser mayor a 8 caracteres", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "#";
		}
		if (!validateEmail(email)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El email es invalido", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "#";
		}

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

	private boolean validateEmail(String mail) {

		String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();

	}

}