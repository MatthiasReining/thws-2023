package de.thws.students.students.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentCreateDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    @NotNull
    private LocalDate birthday;
    @NotEmpty
    @Email
    private String privateEmail;
    // @NotEmpty
    private String degreeProgramKey;

}
