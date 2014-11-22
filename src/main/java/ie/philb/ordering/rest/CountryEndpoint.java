package ie.philb.ordering.rest;

import java.util.List;

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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import ie.philb.ordering.model.Country;
import ie.philb.ordering.service.ServiceException;
import ie.philb.ordering.service.impl.CountryService;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 */
@Stateless
@Path("/countries")
public class CountryEndpoint {

    @EJB
    CountryService countryService;

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(Country entity) {
        try {
            countryService.create(entity);
        } catch (ServiceException ex) {
            return Response.status(Status.CONFLICT).build();
        }
        return Response.created(UriBuilder.fromResource(CountryEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {

        try {
            countryService.delete(id);
        } catch (ServiceException ex) {
            return Response.status(Status.NOT_FOUND).build();

        }

        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces({"application/xml", "application/json"})
    public Response findById(@PathParam("id") Long id) {

        try {
            Country country = countryService.get(id);
            return Response.ok(country).build();
        } catch (ServiceException ex) {
            return Response.status(Status.NOT_FOUND).build();

        }
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Country> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
        List<Country> countries = new ArrayList<>();

        try {
            countries = countryService.list();
        } catch (ServiceException sx) {

        }
        return countries;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes({"application/xml", "application/json"})
    public Response update(Country entity) {

        try {
            countryService.update(entity);
        } catch (ServiceException sx) {
            return Response.status(Status.CONFLICT).build();

        }

        return Response.noContent().build();
    }
}
