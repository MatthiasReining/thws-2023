package de.thws.students;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@QuarkusTest
public class MpResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/mp")
          .then()
             .statusCode(Status.OK.getStatusCode())
             .body(is("Hello THWS from Würzburg"));
    }


    @Test
    public void testHelloEndpointViaJaxRSClient() {
       ClientBuilder cb = ClientBuilder.newBuilder();
        Client c = cb.build();

        Response response = c.target("http://localhost:8080/")
                .path("mp")
                .request()
                .get();

        Assertions.assertEquals(Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Hello THWS from Würzburg", response.readEntity(String.class));
    }

}