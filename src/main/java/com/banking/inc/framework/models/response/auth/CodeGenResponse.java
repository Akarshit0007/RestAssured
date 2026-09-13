package com.banking.inc.framework.models.response.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeGenResponse {
    private Integer verificationCode;
}
