package masini.colocation.controllers;


import java.util.List;

import masini.colocation.dao.DAOUser;
import masini.colocation.model.User;

public class UserManager {
	static DAOUser daoUser = new DAOUser();

	public static List<User> getUsers() {
		List<User> users = daoUser.findAll();
		return users;
	}

	public static User getUser(String login) {		
		if (login==null)
			return null;
		
		User user=daoUser.find(login);
		return user;
	}
	
	public static User login(String login, String password) {		
		User u=daoUser.find(login);
		if(u!=null && u.getPassword().equals(password))
			return u;
		return null;
	}
	
	public static boolean createUser(String login, String password, String firstname, String lastname) {
		User user = daoUser.find(login);
		if (user == null) {
			daoUser.create(new User(login, password, firstname, lastname));
			return true;
		}
		return false;
	}

}
