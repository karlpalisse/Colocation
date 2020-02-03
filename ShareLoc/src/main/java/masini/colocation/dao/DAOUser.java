package masini.colocation.dao;

import masini.colocation.model.User;

import java.util.List;


public interface DAOUser {
    void ajouter( User utilisateur );
    List<User> lister();
    User getUser(int id);
}