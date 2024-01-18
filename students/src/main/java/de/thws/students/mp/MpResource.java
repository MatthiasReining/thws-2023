package de.thws.students.mp;

import java.util.Properties;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("mp")
public class MpResource {

    @Inject
    @ConfigProperty(name = "thws.location")
    String location;

    @RolesAllowed("admin")
    @GET
    public String test() {

        return "Hello THWS from " + location;
    }
}
