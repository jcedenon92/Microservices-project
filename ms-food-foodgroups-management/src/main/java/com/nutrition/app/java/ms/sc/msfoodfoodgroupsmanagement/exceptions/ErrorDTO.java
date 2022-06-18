package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private LocalDateTime datetime;
    private String message;
    private String path;
}
