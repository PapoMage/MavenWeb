package controller;

import model.User;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.JOptionPane;

import db.UserDB;

@Stateless
public class UserController {

	@Inject
	private UserDB db;

	public boolean isValid(String email, String password){
		for(User user : db.users){
			if(user.getEmail().equals(email) && user.getPassword().equals(password)){
				return true;		
			}
		}
		return false;
	}
	
	public User getUserAuth(String email, String password){
		for(User user : db.users){
			if(user.getEmail().equals(email) && user.getPassword().equals(password)){
				return user;		
			}
		}
		return null;
	}

	public boolean usernameExist(String email){
		for(User user : db.users){
			if(user.getEmail().equals(email) ){
				return true;		
			}
		}
		return false;
	}

	public void register(User user){
		if(usernameExist(user.getEmail())){
			JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, por favor ingrese uno distinto");
		}else {
		user.setId(db.nextId());
		db.users.add(user);
		}
	}

	public List<User> getUsers(){
		return db.getUsers();
	}



}
