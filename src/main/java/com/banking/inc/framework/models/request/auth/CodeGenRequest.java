package com.banking.inc.framework.models.request.auth;

public class CodeGenRequest {
    private String email;

    public CodeGenRequest(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
