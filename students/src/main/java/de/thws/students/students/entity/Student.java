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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries({
        @NamedQuery(name = Student.FIND_BY_STUDENT_NUMBER, query = "SELECT s FROM Student s WHERE s.studentNumber = :"
                + Student.PARAM_STUDENT_NUMBER),
        @NamedQuery(name = Student.FIND_ALL, query = "SELECT s FROM Student s")
})

public class Student {
    public static final String FIND_ALL = "Student.findAll";
    public static final String FIND_BY_STUDENT_NUMBER = "Student.findByStudentNumber";
    public static final String PARAM_STUDENT_NUMBER = "studentNumber";

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

    private String firstCourse;

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
                .degreeProgram(this.getDegreeProgram().toDTO())
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
