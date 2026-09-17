package com.banking.inc.framework.services;

import com.banking.inc.framework.client.ApiClient;
import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.framework.models.request.auth.CodeGenRequest;
import com.banking.inc.framework.models.request.auth.CodeVerifyRequest;
import io.restassured.response.Response;

public class AuthService {
    private final ApiClient apiClient;

    public AuthService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Response requestVerificationCode(String email) {
        CodeGenRequest payload = new CodeGenRequest(email);
        return apiClient.post(ConfigManager.required("codeGenerate"), payload);
    }

    public Response verifyCode(String email, Object code) {
        CodeVerifyRequest payload = new CodeVerifyRequest(email, code);
        return apiClient.post(ConfigManager.required("codeVerify"), payload);
    }
}