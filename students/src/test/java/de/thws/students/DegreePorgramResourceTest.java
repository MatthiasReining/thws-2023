package de.thws.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.thws.students.degreeprogrammes.dto.DegreeProgramDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@QuarkusTest
public class DegreePorgramResourceTest {

    @Test
    public void testGetDegreeProgram() {
        ClientBuilder cb = ClientBuilder.newBuilder();
        Client c = cb.build();

        DegreeProgramDTO dp = c.target("http://localhost:8080/")
                .path("degree-programmes")
                .path("1")
                .request()
                .get(DegreeProgramDTO.class);
 
        System.out.println(dp); 
        Assertions.assertNotNull(dp); 
        Assertions.assertEquals("BIN", dp.getKey());
    }

}