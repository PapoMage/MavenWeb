package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager em;

	public List<Post> getPosts() {
		CriteriaQuery<Post> cq = em.getCriteriaBuilder().createQuery(Post.class);
		cq.select(cq.from(Post.class));
		return em.createQuery(cq).getResultList();
	}

	public List<Post> getPostsByUser(User user) {

		String hql = "Select p from Post p where p.user_id = :user_id";
		TypedQuery<Post> q = em.createQuery(hql, Post.class);
		q.setParameter("user_id", user.getId());

		return q.getResultList();
	}

	public void addPost(Post post) {
		em.persist(post);
	}
}
