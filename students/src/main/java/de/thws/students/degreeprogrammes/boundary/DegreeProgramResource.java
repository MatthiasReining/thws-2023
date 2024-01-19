package de.thws.students.degreeprogrammes.boundary;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("degree-programmes")
public class DegreeProgramResource {

    @Inject
    EntityManager em;

    @GET
    @Path("{id}")
    public DegreeProgram getDegreeProgram(@PathParam("id") Long id) {

        DegreeProgram dp = em.find(DegreeProgram.class, id);

        return dp;
    }
}
