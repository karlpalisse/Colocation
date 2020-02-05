package masini.colocation.paths;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import masini.colocation.controllers.UserManager;
import masini.colocation.model.User;
import masini.colocation.security.SigninNeeded;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("user")
public class UserService {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@SigninNeeded
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id ) {
    	User user = UserManager.getUser(id);
    	
		if (user != null) {
		    //GenericEntity<List<Flight>> entity = new GenericEntity<List<Flight>>(lv) {};
		    return Response.ok().entity(user).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
    	List<User> list = UserManager.getUsers();
    	
    	if (list != null) {
		    //GenericEntity<List<Flight>> entity = new GenericEntity<List<Flight>>(lv) {};
		    return Response.ok().entity(list).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
    }
}
