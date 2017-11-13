package view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

@Named
@SessionScoped
public class UserMb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UserController uc;

	public List<User> getUsers() {
		return uc.getUsers();
	}
	
	public void deleteUser(User user) {
		
		uc.removeUser(user);
	}

}
