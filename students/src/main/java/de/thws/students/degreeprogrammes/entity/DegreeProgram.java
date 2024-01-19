package de.thws.students.degreeprogrammes.entity;

import java.util.List;

import de.thws.students.degreeprogrammes.dto.DegreeProgramDTO;
import de.thws.students.students.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = DegreeProgram.FIND_BY_KEY, query = "SELECT dp FROM DegreeProgram dp WHERE dp.key = :"
        + DegreeProgram.PARAM_KEY)
public class DegreeProgram {

    public static final String FIND_BY_KEY = "DegreeProgram.FindByKey";
    public static final String PARAM_KEY = "key";

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
        DegreeProgramDTO dto = new DegreeProgramDTO();
        dto.setBoss(boss);
        dto.setKey(key);
        dto.setName(name);
        return dto;
    }
}
