package com.banking.inc.tests.auth.services;

import com.banking.inc.framework.client.ApiClient;
import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.framework.models.request.auth.LoginRequest;

import io.restassured.response.Response;

public class LoginCodesService {
    
    private final ApiClient apiClient;

    public LoginCodesService(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    public Response Login(String email, String password){
        LoginRequest payload = new LoginRequest(email, password);
        return apiClient.post(ConfigManager.required("loginPath"), payload);
    }
}
