package db;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import model.Post;


@Singleton
public class PostDB {
	
	public List<Post> posts = new ArrayList<Post>();
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	private int id=0;
	
	public PostDB() {

		posts.add(new Post("Admin","Esto tiene contenido"));
	}
	
	public int nextId() {
		id++;
		return id;
	}

	public List<Post> getPosts(){
		return posts;
	}

	
	
}
