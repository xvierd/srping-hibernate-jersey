package com.jersey.resources;

import com.jersey.persistence.AutomovilDAO;
import com.jersey.representations.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Xavier Guti&#233;rrez
 *         06/04/17.
 */
@Path("/auto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class AutoResource {
    private final AutomovilDAO automovilDAO;


    @Inject
    public AutoResource(AutomovilDAO automovilDAO) {
        this.automovilDAO = automovilDAO;
    }


    /**
     * crea un nuevo Auto
     * @param auto
     * @return nuevo auto
     */
    @POST
    public Response.ResponseBuilder saveAuto(@Valid Auto auto){
        automovilDAO.save(auto);
        return Response.status(201);
    }

    /**
     * devuelve todos los Autos
     * @return autos
     */
    @GET
    public Response.ResponseBuilder getAll(){
        return Response.ok(this.automovilDAO.findAll());
    }

    /**
     * devuelve un unico auto
     * @param id
     * @return auto
     */
    @GET
    @Path("{id}")
    public Response.ResponseBuilder getOne(@PathParam("id")long id){
        Auto auto = automovilDAO.findOne(id);
        if(auto == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return Response.ok(automovilDAO.save(auto));
        }
    }

    /**
     * actualiza un auto existente
     * @param id
     * @param auto
     * @return auto
     */
    @PUT
    @Path("{id}")
    public Response.ResponseBuilder update(@PathParam("id")long id, @Valid Auto auto){
        if(automovilDAO.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            auto.setId(id);
            return Response.ok(automovilDAO.save(auto));
        }
    }

    /**
     * Elimina un auto
     * @param id
     */
    @DELETE
    @Path("{id}")
    public Response.Status delete(@PathParam("id")long id) {
        Auto auto = automovilDAO.findOne(id);
        if(auto == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            automovilDAO.delete(auto);
            return Response.Status.OK;
        }
    }

}