package de.thws.students.studentassociation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter  @Setter
@Entity
@NamedQuery(name = StudentAssociationInfo.FIND_BY_NAME, query = "SELECT sai FROM StudentAssociationInfo sai WHERE name = :"
        + StudentAssociationInfo.PARAM_NAME)
public class StudentAssociationInfo {

    public static final String FIND_BY_NAME = "de.thws.students.studentassociation.entity.findByName";
    public static final String PARAM_NAME = "name";

    @GeneratedValue
    @Id
    Long id;

    @NonNull
    String name;

    Long numberOfMembers;
}
