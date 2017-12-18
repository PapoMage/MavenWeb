package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Favorite;
import model.Post;
import model.User;

@Stateless
public class FavoriteController {

	@PersistenceContext
	private EntityManager em;

	public List<Favorite> getFavorites() {
		String hql = "Select f from Favorite f ";
		TypedQuery<Favorite> q = em.createQuery(hql, Favorite.class);
		return q.getResultList();
	}

	public void addFavorite(Favorite favorite) {
		
		String hql = "Select f from Favorite f where f.user = :user and f.post = :post ";
		TypedQuery<Favorite> q = em.createQuery(hql, Favorite.class);
		q.setParameter("user", favorite.getUser());
		q.setParameter("post", favorite.getPost());
		
		if (q.getResultList().isEmpty()) {
			em.persist(favorite);
		}else {
			em.remove(em.find(Favorite.class, q.getSingleResult().getId()));
		}
		
	}

	public List<Favorite> getByPost(Post post) {
		String queryComment = "Select f From Favorite f where f.post = :post";
		TypedQuery<Favorite> tq = em.createQuery(queryComment, Favorite.class);
		tq.setParameter("post", post);
		return tq.getResultList();
	}
	
	public List<Favorite> getByPostUnique(Post post, User user) {
		String queryComment = "Select f From Favorite f where f.post = :post and f.user = :user";
		TypedQuery<Favorite> tq = em.createQuery(queryComment, Favorite.class);
		tq.setParameter("post", post);
		tq.setParameter("user", user);
		return tq.getResultList();
	}
	
	public void removeFavorite(Favorite favorite) {
		em.remove(em.find(Favorite.class, favorite.getId()));
	}

}
