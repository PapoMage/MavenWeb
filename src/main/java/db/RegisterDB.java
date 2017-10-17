package db;

import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

@Named
public class RegisterDB {
@Inject 
private UserController userCntrl;

private String email;
private String password;

public String register(){
	User user = new User(email, password);
	userCntrl.register(user);
	return "index";
}

public UserController getUserCntrl() {
	return userCntrl;
}

public void setUserCntrl(UserController userCntrl) {
	this.userCntrl = userCntrl;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail(){
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}
