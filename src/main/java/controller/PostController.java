package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.JOptionPane;

import db.PostDB;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@Inject
	PostDB bd;

	public List<Post>getPosts(){
		return bd.getPosts();

	}
	
	public List<Post> getPostsByUser(User user){
		List<Post> lista =  new ArrayList<Post>();
		for(Post post : bd.getPosts()){
			if(post.getUser().getId() == user.getId()) {
				lista.add(post);
			}
		}
		
		return lista;
	}

	public void addPost(Post post) {
		post.setId(bd.nextId());
		bd.posts.add(post);
	}
}
