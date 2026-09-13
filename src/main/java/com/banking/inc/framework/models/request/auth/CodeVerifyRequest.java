package com.banking.inc.framework.models.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CodeVerifyRequest {
    private String email;

    @JsonProperty("verificationCode")
    private Object verificationCode;
}