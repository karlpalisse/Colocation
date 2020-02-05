package masini.colocation.controllers;

import java.util.List;

import masini.colocation.dao.DAOColocation;
import masini.colocation.dao.DAOUser;
import masini.colocation.model.Colocation;
import masini.colocation.model.User;

public class ColocationManager {
	static DAOColocation daoColoc = new DAOColocation();
	static DAOUser daoUser = new DAOUser();

	public static List<Colocation> getColocations() {
		List<Colocation> coloc = daoColoc.findAll();
		return coloc;
	}

	public static boolean addMember(String name, String login) {
		Colocation coloc = daoColoc.find(name);
		User user = daoUser.find(login);
		
		if (coloc != null && user != null) {
			
			coloc.addMember(user);
			daoColoc.edit(coloc);
			
			return true;
		}
		return false;
	}
	
	public static Colocation getColocation(String login) {		
		if (login==null)
			return null;
		
		Colocation coloc = daoColoc.find(login);
		return coloc;
	}
	
	public static boolean createColocation(String name) {
		Colocation coloc = daoColoc.find(name);
		if (coloc == null) {
			daoColoc.create(new Colocation(name));
			return true;
		}
		return false;
	}

}
