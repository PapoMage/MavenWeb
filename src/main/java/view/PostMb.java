package view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


import controller.ImagePostController;
import controller.PostController;
import model.ImagePost;
import model.Post;

@Named
@SessionScoped
@MultipartConfig(location="/tmp",
fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5,
maxRequestSize=1024*1024*5*5)
public class PostMb implements Serializable {

	private static final long serialVersionUID = 8869119914552376694L;

	@Inject
	PostController pc;
	@Inject
	AuthMb authMb;
	@Inject 
	ImagePostController imgCntl;
	
	private Part file;

	String contenido;

	public List<Post> getPosts() {
		return pc.getPosts();
	}

	public List<Post> getMyPosts() {
		return pc.getPostsByUser(authMb.getUser());
	}

	public void crearPost() {
		if (contenido.length() != 0 ) {
			ImagePost img;
			Post post = new Post();
			post.setContenido(contenido);
			post.setDate(new Date());
			post.setUser(authMb.getUser());
			post.setUser_id(authMb.getUser().getId());
			try{
				img = null;
				if(file != null && file.getSize() > 0 && file.getContentType().startsWith("image/")){
					img = imgCntl.upload(file);
					post.setImage(img);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
				
			pc.addPost(post);
		}
		
		contenido = null;
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
	
	
	public String getIsImage(Post post) {
		
		String isImage;
		
		if(post.getImage() == null) {
			isImage = "";
		}else {
			isImage = "crop_original";
		}
		
		return isImage;
	}
	
	public String getSrcImage(Post post){
		
		String src;
		
		if(post.getImage() == null) {
			src = "images/post-default.jpg";
		}else {
			src = "/imagepost/"+post.getImage().getPath();
		}
		
		return src;
	}

}
