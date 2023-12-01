package de.thws.students.students.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import de.thws.students.students.dto.StudentCreateDTO;
import de.thws.students.students.dto.StudentDTO;
import de.thws.students.students.dto.ThwsValidationDTO;
import de.thws.students.students.entity.Student;
import de.thws.students.students.entity.StudentStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentService {

    @PersistenceContext
    EntityManager em;

    static Map<Integer, Student> studentDb = new HashMap<>();

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student findByStudentNumber(Integer studentNumber) {
        return studentDb.get(studentNumber);
    }

    public List<Student> list(int limit, int offset) {

        return studentDb.values().stream().toList();
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

        // TODO load DegreeProgram by degreeProgramKey
        DegreeProgram dp = null;

        newStudent.setDegreeProgram(dp);
        newStudent.setStudentNumber(RandomStringUtils.randomAlphanumeric(10).toUpperCase());

        String email = student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase() + "@thws.de";
        newStudent.setEmail(email);
        newStudent.setStatus(StudentStatus.ACTIVE);

        return em.merge(newStudent).toDTO();
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
