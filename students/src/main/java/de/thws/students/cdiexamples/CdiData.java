package de.thws.students.cdiexamples;

import java.io.Serializable;
import java.time.ZonedDateTime;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
public class CdiData implements Serializable {

    private String name;
    private String data1;
    private ZonedDateTime created;
    private ZonedDateTime manualTimestamp;

    public CdiData() {
        System.out.println("CdiData#constructor");
        created = ZonedDateTime.now();
    }

    @PostConstruct
    void init() {
        System.out.println("CdiData#init");
        manualTimestamp = ZonedDateTime.now();

    }
}
