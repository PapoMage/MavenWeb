package controller;

import model.User;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class UserController {

	@PersistenceContext
	private EntityManager em;

	public boolean isValid(String email, String password) {

		String hql = "Select u from User u where u.email = :email AND u.password = :password";
		TypedQuery<User> q = em.createQuery(hql, User.class);
		q.setParameter("email", email);
		q.setParameter("password", password);

		try {
			if (q.getSingleResult().getEmail().equals(email) && q.getSingleResult().getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña invalidos",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return false;

	}

	public User getUserAuth(String email, String password) {

		String hql = "Select u from User u where u.email = :email AND u.password = :password";
		TypedQuery<User> q = em.createQuery(hql, User.class);
		q.setParameter("email", email);
		q.setParameter("password", password);

		try {
			if (q.getSingleResult().getEmail().equals(email) && q.getSingleResult().getPassword().equals(password)) {
				return q.getSingleResult();
			}
		} catch (Exception e) {
			// TODO: Imprimir alerta en html
		}

		return null;
	}

	public boolean usernameExist(String email) {

		String hql = "Select u from User u where u.email = :email";
		TypedQuery<User> q = em.createQuery(hql, User.class);
		q.setParameter("email", email);

		try {
			if (q.getSingleResult().getEmail().equals(email)) {
				return true;
			}
		} catch (Exception e) {
			// TODO: Imprimir alerta en html
		}

		return false;
	}

	public User byId(int id) {
		return em.find(User.class, id);
	}

	public void register(User user) {
		em.persist(user);
	}

	public List<User> getUsers() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		return em.createQuery(cq).getResultList();
	}
	
	public void removeUser(User user) {
		em.remove(em.find(User.class, user.getId()));
	}

}
