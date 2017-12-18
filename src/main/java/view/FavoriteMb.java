package view;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import controller.FavoriteController;
import controller.PostController;
import model.Favorite;
import model.Post;

@Named
public class FavoriteMb {

	@Inject
	FavoriteController fc;
	@Inject
	AuthMb authMb;
	@Inject
	PostController pc;

	public List<Favorite> getFavorites() {
		return fc.getFavorites();
	}

	public void crearFavorite(Post post) {
		if (!post.getUser().getEmail().equals(authMb.getUser().getEmail())) {

			Favorite favorite = new Favorite();
			favorite.setStatus(true);
			favorite.setPost(post);
			favorite.setUser(authMb.getUser());

			fc.addFavorite(favorite);

		}
	}

	public void deleteFavorite(Favorite favorite) {
		fc.removeFavorite(favorite);
	}

	public String getIfExists(Post post) {
		List<Favorite> favorites = fc.getByPostUnique(post, authMb.getUser());

		if (favorites.isEmpty()) {
			return "favorite";
		}

		return "favorite_border";
	}

	public String getMessageFromTotalFavorites(Post post) {
		int count = fc.getByPost(post).size();
		String msg;
		if (count == 0) {
			msg = "";
		} else {
			msg = count + " Likes";
		}
		return msg;
	}
}
