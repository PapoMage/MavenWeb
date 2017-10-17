package view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JOptionPane;

import controller.UserController;

@Named
@SessionScoped
public class AuthMb implements Serializable {

	private static final long serialVersionUID = 5873154859376769728L;

	@Inject
	private UserController userCntr;
	private String email;
	private String password;

	private boolean currentUser;

	public boolean isLogged() {
		return currentUser != false;
	}

	public String loggin() {
		currentUser = userCntr.isValid(email, password);
		email = null;
		password = null;
		if (isLogged()) {
			return "home";
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
			return null;
		}
	}

	public String logout() {
		currentUser = false;
		return "index.xhtml";
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(boolean currentUser) {
		this.currentUser = currentUser;
	}

	public String register() {
		return "register.xhtml";
	}

}
