package ug.adamtrawinski.restejbjpa.rest;

import ug.adamtrawinski.restejbjpa.domain.SerialCode;
import ug.adamtrawinski.restejbjpa.service.SerialCodeManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("serial-code")
@Stateless
public class SerialCodeRESTService {

	@Inject
	private SerialCodeManager pm;

	@GET
	@Path("/{serialCodeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SerialCode getSerialCode(@PathParam("serialCodeId") long id) {
		return pm.getSerialCode(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SerialCode> getSerialCodes() {
		return pm.getAllSerialCodes();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSerialCode(SerialCode serialCode) {
		pm.addSerialCode(serialCode);
		return Response.status(Response.Status.CREATED).entity("SerialCode").build();
	}

	@PUT
	@Path("/{serialCodeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SerialCode updateSerialCode(@PathParam("serialCodeId") long id, SerialCode serialCode) {
		return pm.updateSerialCode(serialCode, id);
	}


	@DELETE
	public Response clearSerialCodes() {
		pm.deleteAllSerialCodes();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{serialCodeId}")
	public Response deleteSerialCode(@PathParam("serialCodeId") long id) {
		pm.deleteSerialCode(id);
		return Response.status(200).build();
	}

}
