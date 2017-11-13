package view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

@Named
@SessionScoped
public class AuthMb implements Serializable {

	private static final long serialVersionUID = 5873154859376769728L;

	@Inject
	private UserController userCntr;

	private String email;
	private String password;

	private boolean currentUser;
	private User user;

	public boolean isLogged() {
		return user != null;
	}

	public String loggin() {
	
		currentUser = userCntr.isValid(email, password);
		user = userCntr.getUserAuth(email, password);
		email = null;
		password = null;
		
		if (isLogged()) {
			return "home?faces-redirect=true";
		} else {
			return null;
		}		
	}

	public String logout() {
		currentUser = false;
		return "index.xhtml";
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

	public User getUser() {
		return user;
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
