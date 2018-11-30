package ug.adamtrawinski.rest.rest;

import ug.adamtrawinski.rest.domain.Laptop;
import ug.adamtrawinski.rest.service.LaptopManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("laptop")
@Stateless
public class LaptopRESTService {

	@Inject
	private LaptopManager lm;

	@GET
	@Path("/{laptopId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Laptop getPerson(@PathParam("laptopId") long id) {
		return lm.getLaptop(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Laptop> getPersons() {
		return lm.getAllLaptops();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLaptop(Laptop laptop) {
		lm.addLaptop(laptop);
		return Response.status(201).entity("Laptop").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Laptop updateLaptop(Laptop laptop) {
		return lm.updateLaptop(laptop);
	}


	@DELETE
	public Response clearLaptops() {
		lm.deleteAllLaptops();
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{laptopId}")
	public Response deleteLaptop(@PathParam("laptopId") long id) {
		lm.deleteLaptop(id);
		return Response.status(200).build();
	}

}
