package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import model.Post;


@Singleton
public class PostDB {
	
	public List<Post> posts = new ArrayList<Post>();
	
	public PostDB() {
		
	}
	
	public int nextId() {
		return posts.size()+1;
	}

	public List<Post> getPosts(){
		return posts;
	}

	
	
}
