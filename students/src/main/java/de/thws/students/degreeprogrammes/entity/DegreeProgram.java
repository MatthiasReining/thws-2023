package de.thws.students.degreeprogrammes.entity;

import java.util.List;

import de.thws.students.degreeprogrammes.dto.DegreeProgramDTO;
import de.thws.students.students.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String key;

    private String boss;

    @OneToMany
    @JoinColumn(name = "degreeprogram_id")
    private List<Student> students;

    public DegreeProgramDTO toDTO() {
        return DegreeProgramDTO.builder()
                .boss(boss)
                .key(key)
                .name(name)
                .build();
    }
}
