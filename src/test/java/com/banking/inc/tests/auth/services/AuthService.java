package com.banking.inc.tests.auth.services;


import java.util.Map;

import com.banking.inc.framework.client.ApiClient;
import com.banking.inc.framework.config.ConfigManager;

import io.restassured.response.Response;

public class AuthService {
    private final ApiClient apiClient;

    public AuthService(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    public Response requestVerificationCode(String email){
        Map<String, String> payload = Map.of("email", email);
        return apiClient.post(ConfigManager.required("codeGenerate"), payload);
    }

    public Response verifyCode(String email, Object code){
        Map<String , Object> payload = Map.of(
            "email", email,
            "code", code
        );
        return apiClient.post(ConfigManager.required("codeVerify"), payload);
    }

}
