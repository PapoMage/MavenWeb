package view;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import controller.CommentController;
import model.Comment;
import model.Post;
import model.User;

@Named
public class CommentMb {

	@Inject
	private CommentController ccontroller;
	
	@Inject
	private AuthMb authMb;
	
	private String content;
	
	public void createComment(Post post) {
		User user = authMb.getUser();
		ccontroller.addComment(user, post, content);
	}
	
	public List<Comment> listByPost(Post post){
		return ccontroller.getByPost(post);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
