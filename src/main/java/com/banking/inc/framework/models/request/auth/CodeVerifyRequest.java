package com.banking.inc.framework.models.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeVerifyRequest {
    private String email;

    @JsonProperty("verificationCode")
    private Object verificationCode;

    public CodeVerifyRequest(String email, Object verificationCode){
        this.email =email;
        this.verificationCode = verificationCode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Object getCode() {
        return verificationCode;
    }
    public void setCode(Object verificationCode){
        this.verificationCode = verificationCode;
    }

}