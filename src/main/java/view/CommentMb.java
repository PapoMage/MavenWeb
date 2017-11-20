package view;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import controller.CommentController;
import model.Comment;
import model.Post;

@Named
public class CommentMb {

	@Inject
	private CommentController ccontroller;
	
	@Inject
	private AuthMb authMb;
	
	private String content;
	
	public void createComment(Post post) {
		ccontroller.addComment(authMb.getUser(), post, content);
	}
	
	public List<Comment> getComments() {
		return ccontroller.getComments();
	}
	
	public List<Comment> listByPost(Post post){
		return ccontroller.getByPost(post);
	}
	
	public int getTotalComments(Post post) {
		return ccontroller.getByPost(post).size();
	}
	
	public void deleteComment(Comment comment) {
		ccontroller.removeComment(comment);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getMessageFromTotalComments(Post post) {
		int count = ccontroller.getByPost(post).size();
		String msg;
		if(count == 0) {
			msg = "";
		}else {
			msg = "Ver comentarios ("+ccontroller.getByPost(post).size()+")";
		}
		return msg;
	}
	
}
