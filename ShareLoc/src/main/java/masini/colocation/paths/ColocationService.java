package masini.colocation.paths;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import masini.colocation.controllers.ColocationManager;
import masini.colocation.controllers.UserManager;
import masini.colocation.model.Colocation;
import masini.colocation.model.User;
import masini.colocation.security.JWTokenUtility;
import masini.colocation.security.SigninNeeded;

@Path("colocation")
public class ColocationService {
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColocation(@PathParam("name") String name ) {
    	Colocation coloc = ColocationManager.getColocation(name);
    	
		if (coloc != null) {
		    //GenericEntity<List<Flight>> entity = new GenericEntity<List<Flight>>(lv) {};
		    return Response.ok().entity(coloc).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
    }
	
	@POST
	@Path("/createColocation")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addColoc(@QueryParam("name") String name) {
		
		if (ColocationManager.createColocation(name))
			return Response.status(Status.CREATED).build();
		return Response.status(Status.CONFLICT).build();
	}
	
	@POST
	@Path("/addMember")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMember(@QueryParam("user") String login, @QueryParam("coloc") String colocation) {
		Colocation coloc = ColocationManager.getColocation(colocation);
		
		if (ColocationManager.addMember(colocation, login)) {
			
		    return Response.ok().entity(coloc).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
		
	}
	
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColocations() {
    	List<Colocation> list = ColocationManager.getColocations();
    	
    	if (list != null) {
		    //GenericEntity<List<Flight>> entity = new GenericEntity<List<Flight>>(lv) {};
		    return Response.ok().entity(list).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
    }
}
