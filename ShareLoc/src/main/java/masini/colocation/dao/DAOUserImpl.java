package masini.colocation.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import masini.colocation.model.User;

public class DAOUserImpl implements DAOUser{
	private DAOFactory daoFactory;

    DAOUserImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void ajouter(User utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> lister() {
		List<User> utilisateurs = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Users;");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String password = resultat.getString("password");
                String email = resultat.getString("email");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");

                User utilisateur = new User();
                utilisateur.setId(id);
                utilisateur.setPassword(password);
                utilisateur.setEmail(email);
                utilisateur.setFirstname(firstname);
                utilisateur.setLastname(lastname);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
	}

	@Override
	public User getUser(int id) {
        User utilisateur = new User();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT * FROM Users WHERE id = ?;");
            statement.setString(1, String.valueOf(id));
            resultat = statement.executeQuery();

            resultat.next();
            String password = resultat.getString("password");
            String email = resultat.getString("email");
            String firstname = resultat.getString("firstname");
            String lastname = resultat.getString("lastname");

            utilisateur.setId(id);
            utilisateur.setPassword(password);
            utilisateur.setEmail(email);
            utilisateur.setFirstname(firstname);
            utilisateur.setLastname(lastname);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
	}
}
