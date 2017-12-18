package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Follower;
import model.User;

@Stateless
public class FollowerController {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Follower> getFollowers() {
		String hql = "Select f from Follower f ";
		TypedQuery<Follower> q = em.createQuery(hql, Follower.class);
		return q.getResultList();
	}
	
	public List<Follower> getFollowersByUser(User user) {
		String hql = "Select f from Follower f where f.userFollow = :user";
		TypedQuery<Follower> q = em.createQuery(hql, Follower.class);
		q.setParameter("user", user);
		return q.getResultList();
	}
	
	public void addFollower(Follower follower,User user, User userFollow) {
		
		String hql = "Select f from Follower f where f.user = :user and f.userFollow = :userFollow ";
		TypedQuery<Follower> q = em.createQuery(hql, Follower.class);
		q.setParameter("user", user);
		q.setParameter("userFollow", userFollow);
		
		if (q.getResultList().isEmpty()) {
			em.persist(follower);
		}else {
			em.remove(em.find(Follower.class, q.getSingleResult().getId()));
		}
		
	}
	
	public List<Follower> getByUserUnique(User user, User userFollow) {
		String hql = "Select f from Follower f where f.user = :user and f.userFollow = :userFollow ";
		TypedQuery<Follower> q = em.createQuery(hql, Follower.class);
		q.setParameter("user", user);
		q.setParameter("userFollow", userFollow);
		return q.getResultList();
	}
	
	public void removeFollower(Follower follower) {
		em.remove(em.find(Follower.class, follower.getId()));
	}
	
	

}
