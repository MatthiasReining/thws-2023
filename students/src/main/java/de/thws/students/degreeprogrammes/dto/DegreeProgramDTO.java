package de.thws.students.degreeprogrammes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DegreeProgramDTO {

    private String name;
    private String key;
    private String boss;
}
