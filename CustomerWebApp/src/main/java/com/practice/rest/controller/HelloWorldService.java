package com.practice.rest.controller;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	@Produces("text/html")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "<html><body><h1 style='color:red'>Jersey say : " + msg
				+ "</h1></body></html>";

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("{id : \\d+}/id")
	public String getString(@PathParam("id") String string) {
		String output = " Jersey Param 2 : " + string;

		// return Response.status(Response.Status.OK).entity(output).build();
		return output;
	}

	@GET
	@Path("/{model}")
	public String getModel(@MatrixParam("model") String model) {
		return model;
	}

	@GET
	@Path("/query")
	public String printQuery(@QueryParam("start") int start,
			@QueryParam("end") int end) {
		return "Query : Start = " + start + "  End = " + end;
	}

	@POST
	@Path("/form")
	@Produces("text/html")
	public String formSubmitted(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName) {
		String response = "<html><body><h1 style='color:red'>Form Submitted with FirstName : "
				+ firstName
				+ " & LastName : "
				+ lastName
				+ "</h1><a href='http://localhost:8080/RESTfulExample/form.jsp'>Go Back</a></body></html>";
		return response;
	}
	
	@GET
	@Path("/collections")
	public String getCollections(@QueryParam("orderBy") List<String> orderBy){
		
		return orderBy.toString();
		
	}
}