package de.thws.students.students.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import de.thws.students.students.entity.StudentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    
    private String studentNumber;

    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private LocalDate birthday;
    private String privateEmail;
    private String email;
    private StudentStatus status;

    private ZonedDateTime created;
    private ZonedDateTime updated;
    private DegreeProgram degreeProgram;

}
