package db;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import model.User;

@Singleton
public class PostDB {
	
	
	public List<User> users = new ArrayList<User>();
	private int id=0;
	
	public PostDB() {
		users.add(new User("martinbobbio1@gmail.com","1234"));
		users.add(new User("pablo.fernandez@davinci.edu.ar","1234"));
	}
	
	public int nextId() {
		id++;
		return id;
	}

	public List<User> getUsers(){
		return users;
	}

	
	
}
