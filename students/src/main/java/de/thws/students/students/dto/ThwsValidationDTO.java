package de.thws.students.students.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThwsValidationDTO {
    private int errorCode;
    private String message;
}
