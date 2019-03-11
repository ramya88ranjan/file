package org.koshik.jb.messenger.resources;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koshik.jb.messenger.service.FileService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myfileresource")

public class MyFileResource {

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
	public Response getIt(@QueryParam("filepath") String filepath,@QueryParam("filename") String filename) throws IOException  {
		System.out.println(filepath+"/"+filename);
		try {
		fs.convertFile(filepath,filename);
		}catch(FileNotFoundException ex) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}


}
