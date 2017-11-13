package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import model.Comment;
import model.Post;
import model.User;

@Stateless
public class CommentController {

	@PersistenceContext
	private EntityManager em;
	
	public void addComment(User user, Post post, String content) {
		post = em.merge(post);
		Comment c = new Comment();
		c.setDate(new Date());
		c.setPost(post);
		c.setUser(user);
		c.setContent(content);
		em.persist(c);
	}
	
	public List<Comment> getComments() {
		CriteriaQuery<Comment> cq = em.getCriteriaBuilder().createQuery(Comment.class);
		cq.select(cq.from(Comment.class));
		return em.createQuery(cq).getResultList();
	}
	
	public List<Comment> getByPost(Post post){
		String queryComment ="Select c From Comment c where c.post = :post";
		TypedQuery<Comment> tq = em.createQuery(queryComment, Comment.class);
		tq.setParameter("post", post);
		return tq.getResultList();
	}
	
	public void removeComment(Comment coment) {
		em.remove(em.find(Comment.class, coment.getId()));
	}
	
	
}
