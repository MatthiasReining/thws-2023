package de.thws.students.cdiexamples;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

public class CdiQuarkusProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public CdiQuarkusData dataProducer() {
        System.out.println("CdiQuarkusProducer#dataProducer");

        // Why should I use a producer?
        // initialize data for example based on app configuration or specific request
        // data

        CdiQuarkusData data = new CdiQuarkusData();
        data.setName("Based on Quarkus Producer");

        return data;
    }
}
