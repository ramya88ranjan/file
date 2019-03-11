package org.koshik.jb.messenger.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koshik.jb.messenger.model.Resource;
import org.koshik.jb.messenger.service.FileService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * 
	 * 
	 */
	FileService fs = new FileService();

	@GET

	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		
		
		return "Got it!";
	}

	/*@POST*/

	/*@Produces(MediaType.TEXT_PLAIN)
	public Response convertIt(Resource resource, @Context UriInfo uriInfo) {
	
		fs.convertFile(resource);

		String newId = String.valueOf(1);
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(resource).build();

	}*/
}
