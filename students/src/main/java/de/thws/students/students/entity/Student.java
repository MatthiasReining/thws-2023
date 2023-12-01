package de.thws.students.students.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import de.thws.students.students.dto.StudentDTO;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    private String studentNumber;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private LocalDate birthday;
    @NotEmpty
    private String email;
    @NotEmpty
    private String privateEmail;
    private StudentStatus status;

    private ZonedDateTime created;
    private ZonedDateTime updated;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    private DegreeProgram degreeProgram;

    @PreUpdate
    @PrePersist
    void setTimeStamps() {
        System.out.println("pre persit");
        if (created == null)
            created = ZonedDateTime.now();
        updated = ZonedDateTime.now();
    }

    public StudentDTO toDTO() {
        return StudentDTO.builder()
                .addressLine1(this.getAddressLine1())
                .addressLine2(this.getAddressLine2())
                .birthday(this.getBirthday())
                .created(this.getCreated())
                .degreeProgram(this.getDegreeProgram())
                .email(this.getEmail())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .privateEmail(this.getPrivateEmail())
                .status(this.getStatus())
                .studentNumber(this.getStudentNumber())
                .updated(this.getUpdated())
                .build();
    }
}
