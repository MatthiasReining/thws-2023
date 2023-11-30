package de.thws.students.students.entity;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private Integer studentNumber;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private LocalDate birthday;
    @Email
    private String email;
    private String status;

}
