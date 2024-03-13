package cz.spsmb.rest;

import cz.spsmb.dao.DogRepository;
import cz.spsmb.model.Dog;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/dogs")
public class DogResource {

    @Inject
    DogRepository dogRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Dog> dogs = dogRepository.listAll();
        return Response.ok().entity(dogs).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Dog dog = dogRepository.findById(id);
        return Response.ok().entity(dog).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        dogRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(Dog dog) {
        dog.setId(0l);
        if (dog.getName() != null && dog.getBreed() !=null && dog.getWeight()> 0) {
            dogRepository.persist(dog);
            return Response.ok().entity("ok").build();
        } else {
            return Response.status(400).entity("Car must have attributes\"price\"model\" and \"brand\".").build();
        }

    }


}
