package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Comment;
import model.Post;
import model.User;

@Stateless
public class CommentController {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addComment(User user, Post post, String content) {
		post = entityManager.merge(post);
		Comment c = new Comment();
		c.setDate(new Date());
		c.setPost(post);
		c.setUser(user);
		c.setContent(content);
		entityManager.persist(c);
	}
	
	public List<Comment> getByPost(Post post){
		String queryComment ="Select c From Comment c where c.post = :post";
		TypedQuery<Comment> tq = entityManager.createQuery(queryComment, Comment.class);
		tq.setParameter("post", post);
		return tq.getResultList();
	}
}
