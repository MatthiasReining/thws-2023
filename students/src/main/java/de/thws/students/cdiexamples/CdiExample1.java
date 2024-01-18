package de.thws.students.cdiexamples;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class CdiExample1 implements Serializable {

    @Inject
    @CdiPayload
    CdiData data;

    @Inject
    CdiQuarkusData data2;


    public CdiExample1() {
        System.out.println("CdiExample1#constructor   " + data);
    }

    @PostConstruct
    void init() {
        // with PostConstruct you have access to "injected" variables.
        // at the constructor everything is still null
        System.out.println("CdiExample1#init   " + data);

        System.out.println("CdiExample1#init - quarkus   " + data2);
    }

    public CdiData getData() {
        return data;
    }

}
