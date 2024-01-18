package de.thws.students.students.control;

import org.eclipse.microprofile.faulttolerance.Retry;

import jakarta.enterprise.context.RequestScoped;
import jakarta.json.JsonArray;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@RequestScoped
public class CoursesClient {

    @Retry(maxRetries = 10, delay = 5000)
    public String getFirstCourse(String degreeProgram) {
        System.out.println("call courses microservice");

        ClientBuilder cb = ClientBuilder.newBuilder();
        Client c = cb.build();

        JsonArray resultArray = c.target("http://localhost:9090/")
                .path("courses")
                .request()
                .get(JsonArray.class);
        System.out.println("courses ws result:");
        System.out.println(resultArray);

        String firstCourse = resultArray.get(0).asJsonObject().getString("name");

        return firstCourse;
    }

}
