package model;

public class Post {

	private int id;
	private String user;
	private String contenido;

	public Post( String user, String contenido) {
		super();
		this.user = user;
		this.contenido = contenido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}



}
