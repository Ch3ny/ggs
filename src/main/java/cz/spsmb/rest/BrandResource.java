package cz.spsmb.rest;

import cz.spsmb.dao.BrandRepository;
import cz.spsmb.dao.BrandRepository;
import cz.spsmb.model.Brand;
import cz.spsmb.model.Brand;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/brands")
public class BrandResource {

    @Inject
    BrandRepository brandRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Brand> brands = brandRepository.listAll();
        return Response.ok().entity(brands).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Brand brand = brandRepository.findById(id);
        return Response.ok().entity(brand).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        brandRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(Brand brand) {
        brand.setName("BMW");
        if (brand.getName() != null && brand.getName() !=null) {
            brandRepository.persist(brand);
            return Response.ok().entity("ok").build();
        } else {
            return Response.status(400).entity("Car must have attributes\"price\"model\" and \"brand\".").build();
        }

    }


}
