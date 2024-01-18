package de.thws.students.cdiexamples.events;

import de.thws.students.students.control.NewStudentEvent;
import de.thws.students.students.dto.StudentDTO;
import jakarta.enterprise.event.Observes;

public class EventExample {
    

    public void eventNotification(@Observes @NewStudentEvent StudentDTO student) {

        System.out.println("Event Example: " + student.getFirstName() + " " + student.getEmail());

    }

}
