package de.thws.courses.control;

import java.util.ArrayList;
import java.util.List;

import de.thws.courses.dto.CoursesDTO;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class CourseService {

    public List<CoursesDTO> getCourses() {

        List<CoursesDTO> result = new ArrayList<>();

        CoursesDTO c = new CoursesDTO();
        c.setName("Cloud Native Java Enterprise");
        result.add(c);

        c = new CoursesDTO();
        c.setName("Programmieren I");
        result.add(c);
        c = new CoursesDTO();
        c.setName("Programmieren II");
        result.add(c);
        c = new CoursesDTO();
        c.setName("Programmieren III");
        result.add(c);

        return result;
    }
}
