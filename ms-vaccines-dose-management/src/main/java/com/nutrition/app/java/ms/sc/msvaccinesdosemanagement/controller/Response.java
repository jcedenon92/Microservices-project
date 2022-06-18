package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private Message message;
    private Object data;
}
