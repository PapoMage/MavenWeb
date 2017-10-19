package db;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import model.User;

@Singleton
public class UserDB {

	public List<User> users = new ArrayList<User>();

	public UserDB() {
		users.add(new User(nextId(),"admin@gmail.com","admin","Admin"));
		users.add(new User(nextId(),"martinbobbio1@gmail.com","1234","Martin"));
	}
	
	public int nextId() {
		return users.size()+1;
	}

	public List<User> getUsers(){
		return users;
	}





}
