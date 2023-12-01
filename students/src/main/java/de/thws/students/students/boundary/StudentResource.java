package de.thws.students.students.boundary;

import java.util.List;

import de.thws.students.students.control.StudentService;
import de.thws.students.students.entity.Student;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
    @Path("todo-rework-endpoint/{studentNumber}")
    public Student getStudentByStudentNumber(@PathParam("studentNumber") @Min(99999) Integer studentNumber) {
        return studentService.findByStudentNumber(studentNumber);
    }

    
    @GET
    @Path("{id}")
    public Student getStudent(@PathParam("id") Long id) {
        return studentService.findById(id);
    }

     
    @PUT
    @Path("{id}")
    public Student updateStudent(@PathParam("id") Long id, @Valid Student student) {
        return studentService.update(id, student);
    }

    @GET
    public List<Student> list(@QueryParam("limit") @DefaultValue("20") int limit,
            @QueryParam("offset") @DefaultValue("0") int offset) {

        return studentService.list(limit, offset);

    }

}
