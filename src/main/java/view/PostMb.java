package view;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import controller.ImageController;
import controller.PostController;
import model.Image;
import model.Post;

@Named
@SessionScoped
public class PostMb implements Serializable {

	private static final long serialVersionUID = 8869119914552376694L;

	@Inject
	PostController pc;
	@Inject
	AuthMb authMb;
	@Inject
	ImageController imgController;
	
	private Part file;

	String contenido;

	public List<Post> getPosts() {
		return pc.getPosts();
	}

	public List<Post> getMyPosts() {
		return pc.getPostsByUser(authMb.getUser());
	}

	public void crearPost() throws IOException {
		Image img = null;
		if (contenido != "" && file !=null) {
			img = imgController.upload(file);
			Post post = new Post();
			post.setContenido(contenido);
			post.setDate(new Date());
			post.setUser(authMb.getUser());
			post.setUser_id(authMb.getUser().getId());

			pc.addPost(post, img);

			contenido = null;
		}
	}
	
	public void deletePost(Post post) {
		pc.removePost(post);
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Part getFile() {
		return file;
	}
		
	public void setFile(Part file) {
		this.file = file;
	}

}
