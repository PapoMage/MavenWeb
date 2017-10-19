package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {

	private int id;
	private User user;
	private String contenido;
	private Date date;

	public Post(User user, String contenido, Date date) {
		this.date = date;
		this.user = user;
		this.contenido = contenido;
	}
	public Post(int id, User user, String contenido, Date date) {
		this.id = id;
		this.date = date;
		this.user = user;
		this.contenido = contenido;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getDate() {
		return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	



}
