package de.thws.students.students.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import de.thws.students.students.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentService {

    static Map<Integer, Student> studentDb = new HashMap<>();

    public Student persist(Student student) {

        int studentNumber = new Random().nextInt();

        student.setStudentNumber(studentNumber);

        studentDb.put(studentNumber, student);

        return student;

    }

    public Student findByStudentNumber(Integer studentNumber) {
        return studentDb.get(studentNumber);
    }

    public List<Student> list(int limit, int offset) {

        return studentDb.values().stream().toList();
    }
}
