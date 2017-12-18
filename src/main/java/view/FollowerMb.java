package view;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import controller.FollowerController;
import model.Follower;
import model.User;

@Named
public class FollowerMb {
	
	@Inject
	FollowerController fc;
	@Inject
	AuthMb authMb;
	
	public List<Follower> getFollowers() {
		return fc.getFollowers();
	}
	
	public void crearFollower(User userFollow) {
		
		Follower follower = new Follower();
		follower.setUser(authMb.getUser());
		follower.setUserFollow(userFollow);
		
		fc.addFollower(follower, authMb.getUser(), userFollow);
		
	}
	
	public void deleteFollower(Follower follower) {
		fc.removeFollower(follower);
	}
	
	public String getIfExists(User userFollow) {
		List<Follower> favorites = fc.getByUserUnique(authMb.getUser(), userFollow);
		
		if(favorites.isEmpty()) {
			return "person_add";
		}
		
		return "cancel";
	}
	
	public String getMessageFollow(User userFollow) {
		
		List<Follower> favorites = fc.getByUserUnique(authMb.getUser(), userFollow);
		
		if(favorites.isEmpty()) {
			return "No seguido";
		}
		
		return "Seguido";
	}
	
	public String getMessageFollowColor(User userFollow) {
		
		List<Follower> favorites = fc.getByUserUnique(authMb.getUser(), userFollow);
		
		if(favorites.isEmpty()) {
			return "red-text";
		}
		
		return "green-text";
	}
	
	public int getFollowersByUser(User userFollow) {
		int count = fc.getFollowersByUser(userFollow).size();
		
		return count;
		
		
	}
		
	
	

}
