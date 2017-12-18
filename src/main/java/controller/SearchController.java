package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.User;

@Stateless
public class SearchController {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<User> getBySearch(String searchText, int id) {
		String queryComment = "Select u From User u where (u.name like :search or u.email like :search) and u.id <> :id";
		TypedQuery<User> tq = em.createQuery(queryComment, User.class);
		tq.setParameter("search", searchText+"%");
		tq.setParameter("id", id);
		return tq.getResultList();
	}

}
