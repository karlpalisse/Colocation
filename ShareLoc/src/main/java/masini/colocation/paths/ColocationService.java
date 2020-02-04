package masini.colocation;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import masini.colocation.dao.DAOFactory;
import masini.colocation.model.User;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id ) {
    	DAOFactory daoFactory = DAOFactory.getInstance();
        return daoFactory.getUtilisateurDao().getUser(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
    	DAOFactory daoFactory = DAOFactory.getInstance();
        return daoFactory.getUtilisateurDao().lister();
    }
}
