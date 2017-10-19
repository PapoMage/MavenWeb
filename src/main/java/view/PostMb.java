package view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import db.PostDB;
import model.Post;
import model.User;

@Named
@SessionScoped
public class PostMb implements Serializable{

	private static final long serialVersionUID = 8869119914552376694L;

	@Inject PostController pc;
	@Inject AuthMb authMb;
	
	String contenido;

	public List<Post> getPosts(){
		return pc.getPosts();
	}
	
	public List<Post> getMyPosts(){
		return pc.getPostsByUser(authMb.getUser());
	}

	public String crearPost() {
		if(contenido != ""){
			Post post = new Post(authMb.getUser(), contenido, new Date());
			pc.addPost(post);
			contenido = null;
		}
		return "home?faces-redirect=true";
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
