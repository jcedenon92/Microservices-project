package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private Message message;
    private Object data;
}
