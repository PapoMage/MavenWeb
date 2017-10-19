package view;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JOptionPane;

import controller.UserController;
import db.UserDB;
import model.User;

@Named
public class RegisterMb implements Serializable{

	private static final long serialVersionUID = -2107638903454277960L;
	@Inject
	private UserController userCntr;
	
	@Inject
	private UserDB userDb;
	private String email;
	private String password;
	private String name;

	public String register(){
		if(email.length()<=4 || password.length()<4) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un usuario o contraseña de mas de 4 caracteres");
			return "register";
		}else {
			User user = new User(userDb.nextId(),email, password,name);
			userCntr.register(user);
		}
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
