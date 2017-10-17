package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import db.PostDB;
import model.Post;

@Stateless
public class PostController {

	@Inject
	PostDB bd;

	public List<Post>getPosts(){
		return bd.getPosts();

	}

	public void addPost(Post post) {
		post.setId(bd.nextId());
		bd.posts.add(post);
	}
}
