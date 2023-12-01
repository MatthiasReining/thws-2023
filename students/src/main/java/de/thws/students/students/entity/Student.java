package de.thws.students.students.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

    private ZonedDateTime created;
    private ZonedDateTime updated;

    @PrePersist
    void setTimeStamps() {
        if (created == null)
            created = ZonedDateTime.now();
        updated = ZonedDateTime.now();
    }

}
