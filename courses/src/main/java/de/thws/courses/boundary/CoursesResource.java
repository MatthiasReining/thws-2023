package de.thws.courses.boundary;

import java.util.List;

import de.thws.courses.control.CourseService;
import de.thws.courses.dto.CoursesDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("courses")
public class CoursesResource {

    @Inject
    CourseService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CoursesDTO> getCourses() {

        return service.getCourses();
    }

}
