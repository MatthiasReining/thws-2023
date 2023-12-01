package de.thws.students.degreeprogrammes.entity;

import java.util.List;
import java.util.UUID;

import de.thws.students.students.entity.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DegreeProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty
    private String name;

    private String boss;

    @OneToMany
    @JoinColumn(name = "degreeprogram_id")
    private List<Student> students;
}
