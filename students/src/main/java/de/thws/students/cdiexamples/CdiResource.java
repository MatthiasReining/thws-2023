package de.thws.students.cdiexamples;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("cdiexamples")
public class CdiResource {

    @Inject
    CdiExample1 ex1;

    
    @Inject
    CdiService service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CdiData test() {

        System.out.println("new request------");

        ex1.getData().setData1("blub");

        System.out.println("-----");

        service.work();

        return ex1.getData();
    }
}
