package de.thws.students.students.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.thws.students.students.dto.ThwsValidationDTO;
import de.thws.students.students.entity.Student;
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
    public Student persist(Student student) {
        return em.merge(student);
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
