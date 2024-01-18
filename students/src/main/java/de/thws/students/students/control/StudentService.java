package de.thws.students.students.control;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import de.thws.students.degreeprogrammes.control.DegreeProgramService;
import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import de.thws.students.students.dto.StudentCreateDTO;
import de.thws.students.students.dto.StudentDTO;
import de.thws.students.students.dto.ThwsValidationDTO;
import de.thws.students.students.entity.Student;
import de.thws.students.students.entity.StudentStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentService {

    @PersistenceContext
    EntityManager em;

    @Inject
    DegreeProgramService dps;

    @Inject
    @NewStudentEvent
    Event<StudentDTO> newStundentEvent;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public StudentDTO findByStudentNumber(String studentNumber) {
        return em.createNamedQuery(Student.FIND_BY_STUDENT_NUMBER, Student.class)
                .setParameter(Student.PARAM_STUDENT_NUMBER, studentNumber)
                .getSingleResult()
                .toDTO();
    }

    public List<StudentDTO> list(int limit, int offset) {
        // TODO add pagination with limit and offset
        return em.createNamedQuery(Student.FIND_ALL, Student.class)
                .getResultStream().map(s -> s.toDTO())
                .toList();

    }

    @Transactional
    public StudentDTO persist(StudentCreateDTO student) {

        Student newStudent = new Student();
        newStudent.setAddressLine1(student.getAddressLine1());
        newStudent.setAddressLine2(student.getAddressLine2());
        newStudent.setBirthday(student.getBirthday());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setPrivateEmail(student.getPrivateEmail());

        DegreeProgram dp = dps.findByKey(student.getDegreeProgramKey());

        newStudent.setDegreeProgram(dp);
        newStudent.setStudentNumber(RandomStringUtils.randomAlphanumeric(10).toUpperCase());

        String email = student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + "@thws.de";
        newStudent.setEmail(email);
        newStudent.setStatus(StudentStatus.ACTIVE);

        newStudent = em.merge(newStudent);

        StudentDTO dtoPayload = newStudent.toDTO();

        System.out.println(LocalDateTime.now() + "fire new student event");

        newStundentEvent.fireAsync(dtoPayload);

        // Example: student-developers are making mistakes... but student assosiations
        // works :-)
        // System.out.println(42/0);

        System.out.println(LocalDateTime.now() + "new student event fired");

        return dtoPayload;
    }

    @Transactional
    public Student update(Long id, Student student) {

        if (id != student.getId()) {
            throw new ThwsValidationException(
                    ThwsValidationDTO.builder()
                            .errorCode(1234)
                            .message("There's no match between path id (" + id + ") and student id (" + student.getId()
                                    + ")")
                            .build());
        }

        return em.merge(student);
    }
}
