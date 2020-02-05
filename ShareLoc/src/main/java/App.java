import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import masini.colocation.dao.DAOUser;
import masini.colocation.model.User;

public class App {

	public static void main(String[] args) {
		
		DAOUser daoUser = new DAOUser();
		
		User user = new User();
		user.setEmail("toto@tutu");
		
		daoUser.create(user);
	}

}
