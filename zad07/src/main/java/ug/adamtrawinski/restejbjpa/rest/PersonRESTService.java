package ug.adamtrawinski.restejbjpa.rest;

import com.fasterxml.jackson.annotation.JsonView;
import ug.adamtrawinski.restejbjpa.domain.Laptop;
import ug.adamtrawinski.restejbjpa.domain.Person;
import ug.adamtrawinski.restejbjpa.service.PersonManager;
import ug.adamtrawinski.restejbjpa.view.View;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("person")
@Stateless
public class PersonRESTService {

	@Inject
	private PersonManager pm;

	@GET
	@Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.PersonSummaryWithRelations.class)
	public Person getPerson(@PathParam("personId") long id) {
		return pm.getPerson(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.PersonSummaryWithRelations.class)
	public List<Person> getPersons() {
		return pm.getAllPersons();
	}

	@GET
	@Path("{personId}/laptops")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(View.LaptopSummaryWithoutOwners.class)
	public List<Laptop> getLaptopOwners(@PathParam("personId") long id) {
		return pm.getLaptops(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		pm.addPerson(person);
		return Response.status(Response.Status.CREATED).entity("Person").build();
	}

	@PUT
	@Path("/{personId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person updatePerson(@PathParam("personId") long id, Person person) {
		return pm.updatePerson(person, id);
	}


	@DELETE
	public Response clearPersons() {
		pm.deleteAllPersons();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{personId}")
	public Response deletePerson(@PathParam("personId") long id) {
		pm.deletePerson(id);
		return Response.status(200).build();
	}

}
