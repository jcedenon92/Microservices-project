package com.nutrition.app.java.ms.sc.msusercustomermanagement.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private Integer code;
    private String message;
}
