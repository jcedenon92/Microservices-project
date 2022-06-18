package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    private Integer code;
    private String message;
}
