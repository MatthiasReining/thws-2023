package de.thws.students.studentassociation.control;

import java.time.LocalDateTime;
import java.util.List;

import de.thws.students.studentassociation.entity.StudentAssociationInfo;
import de.thws.students.students.control.NewStudentEvent;
import de.thws.students.students.dto.StudentDTO;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

public class StudentAssociationService {

    @Inject
    EntityManager em;

    @Transactional(value = TxType.REQUIRES_NEW)
    public void weHaveANewStudentEvent(@ObservesAsync @NewStudentEvent StudentDTO student) {

        System.out.println(LocalDateTime.now() + "student association starts");

        String degreeProgramKey = student.getDegreeProgram().getKey();

        List<StudentAssociationInfo> result = em
                .createNamedQuery(StudentAssociationInfo.FIND_BY_NAME, StudentAssociationInfo.class)
                .setParameter(StudentAssociationInfo.PARAM_NAME, degreeProgramKey)
                .getResultList();

        StudentAssociationInfo sai = null;

        if (result.isEmpty()) {
            sai = new StudentAssociationInfo();
            sai.setName(degreeProgramKey);
            sai.setNumberOfMembers(0L);
            sai = em.merge(sai);
        } else {
            sai = result.get(0);
        }

        sai.setNumberOfMembers(sai.getNumberOfMembers() + 1);

        // heavy work. Welcome package is built

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(LocalDateTime.now() + "Student Association (finished): " + student.getFirstName() + " "
                + student.getEmail());

        System.out.println(42 / 0);

    }

}
