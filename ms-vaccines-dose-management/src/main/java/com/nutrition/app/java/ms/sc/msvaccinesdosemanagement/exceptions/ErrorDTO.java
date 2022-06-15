package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private LocalDateTime datetime;
    private String message;
    private String path;
}
