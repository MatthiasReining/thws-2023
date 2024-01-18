package de.thws.students.cdiexamples.events;

import de.thws.students.students.control.NewStudentEvent;
import de.thws.students.students.dto.StudentDTO;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.ObservesAsync;

public class EventExample {
    

    public void eventNotification(@ObservesAsync @NewStudentEvent StudentDTO student) {

        System.out.println("Event Example: " + student.getFirstName() + " " + student.getEmail());

    }

}
