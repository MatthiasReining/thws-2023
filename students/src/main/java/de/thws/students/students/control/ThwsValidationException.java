package de.thws.students.students.control;

import de.thws.students.students.dto.ThwsValidationDTO;
import jakarta.validation.ValidationException;
import lombok.Getter;

public class ThwsValidationException extends ValidationException {

    @Getter
    ThwsValidationDTO payload;

    public ThwsValidationException(ThwsValidationDTO payload) {
        this.payload = payload;
    }
}
