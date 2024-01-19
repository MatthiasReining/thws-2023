package de.thws.students.cdiexamples;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

public class CdiDataProducer {

    @Produces
    @CdiPayload
    @RequestScoped
    public CdiData dataProducer() {
        System.out.println("CdiDataProducer#dataProducer");

        // Why should I use a producer?
        // initialize data for example based on app configuration or specific request
        // data

        CdiData data = new CdiData();
        data.setName("Based on Producer");

        return data;
    }
}
