package de.thws.students.cdiexamples;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class CdiService {

    
    @Inject
    @CdiPayload
    CdiData data;


    public void work() {
        System.out.println("CdiService#work" + data + "    " + data.getName());
    }
}
