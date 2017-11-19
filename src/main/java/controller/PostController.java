package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Image;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager em;

	public List<Post> getPosts() {
		String hql = "Select p from Post p order by p.date desc";
		TypedQuery<Post> q = em.createQuery(hql, Post.class);
		return q.getResultList();
	}

	public List<Post> getPostsByUser(User user) {

		String hql = "Select p from Post p where p.user_id = :user_id order by p.date desc";
		TypedQuery<Post> q = em.createQuery(hql, Post.class);
		q.setParameter("user_id", user.getId());

		return q.getResultList();
	}

	public void addPost(Post post, Image img) {
		em.persist(post);
		em.persist(img);
	}
	
	public void removePost(Post post) {
		em.remove(em.find(Post.class, post.getId()));
	}
}
