package de.thws.students.students.control;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ThwsValidationExceptionMapper implements ExceptionMapper<ThwsValidationException> {

    @Override
    public Response toResponse(ThwsValidationException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getPayload()).build();
    }

}
