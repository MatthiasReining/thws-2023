package de.thws.students.students.boundary;

import java.util.List;

import de.thws.students.students.control.StudentService;
import de.thws.students.students.entity.Student;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("students")
public class StudentResource {

    @Inject
    StudentService studentService;

    @POST
    public Student createStudent(@Valid Student student) {
        return studentService.persist(student);
    }

    @GET
    @Path("{studentNumber}")
    public Student getStudent(@PathParam("studentNumber") @Min(99999) Integer studentNumber) {
        return studentService.findByStudentNumber(studentNumber);
    }

    @GET
    public List<Student> list(@QueryParam("limit") @DefaultValue("20") int limit,
            @QueryParam("offset") @DefaultValue("0") int offset) {

        return studentService.list(limit, offset);

    }

}
