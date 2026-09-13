package com.banking.inc.framework.models.response.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeGenResponse {
    private Integer verificationCode;

    public Integer getVerificationCode() { return verificationCode; }
    public void setVerificationCode(Integer verificationCode) { this.verificationCode = verificationCode; }
}
