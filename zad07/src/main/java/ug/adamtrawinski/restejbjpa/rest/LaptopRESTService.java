package ug.adamtrawinski.restejbjpa.rest;

import com.fasterxml.jackson.annotation.JsonView;
import ug.adamtrawinski.restejbjpa.domain.Laptop;
import ug.adamtrawinski.restejbjpa.service.LaptopManager;
import ug.adamtrawinski.restejbjpa.view.View;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("laptop")
@Stateless
public class LaptopRESTService {

	@Inject
	private LaptopManager lm;

	@GET
	@Path("/{laptopId}")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummaryWithRelations.class)
	public Laptop getLaptop(@PathParam("laptopId") long id) {
		return lm.getLaptop(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummaryWithRelations.class)
	public List<Laptop> getLaptops() {
		return lm.getAllLaptops();
	}

	@GET
	@Path("/newer-older")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummaryWithRelations.class)
	public Response getLaptopsOlderOrNewer(@QueryParam("releaseDate") String releaseDate, @QueryParam("newer") boolean newer) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(releaseDate);
			return Response.ok(lm.getLaptopsNewerOrOlderThan(newer, date), MediaType.APPLICATION_JSON).build();
		} catch (ParseException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Data musi być w formacie yyyy-MM-dd").build();
		}
	}

	@GET
	@Path("/name-like")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummary.class)
	public List<Laptop> getLaptopsByNameLike(@QueryParam("name") String name) {
		return lm.getLaptopsByNameLike(name);
	}

	@GET
	@Path("/manufacturer")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummary.class)
	public List<Laptop> getLaptopsByManufacturer(@QueryParam("name") String manufacturer) {
		return lm.getLaptopsByManufacturer(manufacturer);
	}

	@GET
	@Path("/serial-code")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummary.class)
	public Laptop getLaptopBySerialCode(@QueryParam("code") String code) {
		return lm.getLaptopBySerialCode(code);
	}

	@GET
	@Path("/price")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummary.class)
	public List<Laptop> getLaptopBySerialCode(@QueryParam("min") double min, @QueryParam("max") double max) {
		return lm.getLaptopsPriceBetween(min, max);
	}

	@GET
	@Path("/owner")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummary.class)
	public List<Laptop> getLaptopsByOwner(@QueryParam("first_name") String firstName) {
		return lm.getLaptopsByOwner(firstName);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLaptop(Laptop laptop) {
		lm.addLaptop(laptop);
		return Response.status(Response.Status.CREATED).entity("Laptop").build();
	}

	@PUT
	@Path("/{laptopId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLaptop(@PathParam("laptopId") long id, Laptop laptop) {
		if(lm.updateLaptop(laptop, id)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}


	@DELETE
	public Response clearLaptops() {
		lm.deleteAllLaptops();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{laptopId}")
	public Response deleteLaptop(@PathParam("laptopId") long id) {
		lm.deleteLaptop(id);
		return Response.status(200).build();
	}

}
