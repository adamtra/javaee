package ug.adamtrawinski.restejbjpa.rest;

import ug.adamtrawinski.restejbjpa.domain.Manufacturer;
import ug.adamtrawinski.restejbjpa.service.ManufacturerManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("manufacturer")
@Stateless
public class ManufacturerRESTService {

	@Inject
	private ManufacturerManager mm;

	@GET
	@Path("/{manufacturerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manufacturer getManufacturer(@PathParam("manufacturerId") long id) {
		return mm.getManufacturer(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manufacturer> getManufacturers() {
		return mm.getAllManufacturers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addManufacturer(Manufacturer manufacturer) {
		mm.addManufacturer(manufacturer);
		return Response.status(Response.Status.CREATED).entity("Manufacturer").build();
	}

	@PUT
	@Path("/{manufacturerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Manufacturer updateManufacturer(@PathParam("manufacturerId") long id, Manufacturer manufacturer) {
		return mm.updateManufacturer(manufacturer, id);
	}


	@DELETE
	public Response clearManufacturers() {
		mm.deleteAllManufacturers();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{manufacturerId}")
	public Response deleteManufacturer(@PathParam("manufacturerId") long id) {
		mm.deleteManufacturer(id);
		return Response.status(200).build();
	}

}
