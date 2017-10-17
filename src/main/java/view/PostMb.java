package view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import model.Post;


public class PostMb implements Serializable{

	private static final long serialVersionUID = 8869119914552376694L;

	@Inject
	PostController pc;
	String id;
	String user;
	String contenido;

	public List<Post> obtenerPosts(){
		return pc.getPosts();
	}

	public String crearPost() {
		Post post = new Post(user, contenido);
		pc.addPost(post);
		return "home";
	}
}
