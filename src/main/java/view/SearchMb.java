package view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.SearchController;
import model.User;

@Named
@SessionScoped
public class SearchMb implements Serializable {

	private static final long serialVersionUID = -8717026257252688558L;

	String searchText;
	int messageUserSearchStatus = 0;
	List<User> usersSearch;

	@Inject
	SearchController sc;
	@Inject
	AuthMb authMb;

	public void searchUser() {
		if (searchText != "") {
			usersSearch = sc.getBySearch(searchText, authMb.getUser().getId());
			if (usersSearch.isEmpty()) {
				messageUserSearchStatus = 1;
			} else {
				messageUserSearchStatus = 2;
			}
		}

	}

	public String updateSearchUserText() {

		if (messageUserSearchStatus == 1) {
			return "No se han encontrado usuarios";
		} else if (messageUserSearchStatus == 2) {
			return "Usuarios encontrados (" + usersSearch.size() + "):";
		}

		return "";
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getMessageUserSearchStatus() {
		return messageUserSearchStatus;
	}

	public void setMessageUserSearchStatus(int messageUserSearchStatus) {
		this.messageUserSearchStatus = messageUserSearchStatus;
	}

	public List<User> getUsersSearch() {
		return usersSearch;
	}

	public void setUsersSearch(List<User> usersSearch) {
		this.usersSearch = usersSearch;
	}

}
