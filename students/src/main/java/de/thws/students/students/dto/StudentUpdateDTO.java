package de.thws.students.students.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentUpdateDTO {

    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private LocalDate birthday;
    private String email;

}
