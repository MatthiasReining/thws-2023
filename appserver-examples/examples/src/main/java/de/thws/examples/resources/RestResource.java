package de.thws.examples.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("hello")
public class RestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDTO hello() {
        HelloDTO hello = new HelloDTO();
        hello.setMessage("Hello from THWS");
        return hello;
    }
}
