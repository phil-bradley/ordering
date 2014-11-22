/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.rest;

import ie.philb.ordering.model.Address;
import ie.philb.ordering.service.ServiceException;
import ie.philb.ordering.service.impl.AddressService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Stateless
@Path("/addresses")
public class AddressEndpoint {

    @EJB
    AddressService addressService;

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(Address entity) {
        try {
            addressService.create(entity);
        } catch (ServiceException ex) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(UriBuilder.fromResource(AddressEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {

        try {
            addressService.delete(id);
        } catch (ServiceException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();

        }

        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces({"application/xml", "application/json"})
    public Response findById(@PathParam("id") Long id) {

        try {
            Address address = addressService.get(id);
            return Response.ok(address).build();
        } catch (ServiceException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();

        }
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Address> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
        List<Address> addesses = new ArrayList<>();

        try {
            addesses = addressService.list();
        } catch (ServiceException sx) {

        }
        return addesses;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes({"application/xml", "application/json"})
    public Response update(Address entity) {

        try {
            addressService.update(entity);
        } catch (ServiceException sx) {
            return Response.status(Response.Status.CONFLICT).build();

        }

        return Response.noContent().build();
    }
}
