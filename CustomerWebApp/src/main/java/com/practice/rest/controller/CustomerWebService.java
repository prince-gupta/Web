package com.practice.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.practice.rest.entity.Customer;
import com.practice.rest.enums.CustomerStatus;
import com.practice.rest.orm.impls.CustomerORMServicesImpl;

@Path("/customers")
public class CustomerWebService {

	private static CustomerORMServicesImpl ormService = new CustomerORMServicesImpl();

	@POST
	@Path("/create")
	@Consumes("application/xml")
	@Produces("text/xml")
	public Customer createCustomer(Customer customer) {
		Customer new_customer = ormService.save(customer);
		new_customer.setStatus(CustomerStatus.CREATED);
		return new_customer;
	}

	@GET
	@Path("/show/{id : \\d+}")
	@Produces("application/xml")
	public Customer getCustomer(@PathParam("id") int id) {
		Customer customer = ormService.get(id);
		if (customer == null) {
			customer = new Customer();
			customer.setId(id);
			customer.setStatus(CustomerStatus.NOTFOUND);
		}
		customer.setStatus(CustomerStatus.FOUND);
		return customer;
	}

	@POST
	@Path("/delete")
	@Consumes("application/xml")
	public Customer deleteCustomer(Customer customer) {
		boolean deleted = ormService.delete(customer);
		if (deleted)
			customer.setStatus(CustomerStatus.DELETED);
		else
			customer.setStatus(CustomerStatus.NOT_DELETED);
		return customer;

	}

	@POST
	@Path("/deleteAndReturn")
	@Consumes("application/xml")
	public List<Customer> deleteAndReturnCustomers(Customer customer) {
		boolean deleted = ormService.delete(customer);
		List<Customer> customers;
		if (deleted) {
			customers = ormService.get();
		} else {
			customers = new ArrayList<Customer>();
			customer.setStatus(CustomerStatus.NOT_DELETED);
			customers.add(customer);
		}
		return customers;

	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomersJSON() {
		return ormService.get();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getCustomers() {
		return ormService.get();
	}


}
