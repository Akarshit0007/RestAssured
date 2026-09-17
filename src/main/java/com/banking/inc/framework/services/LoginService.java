package com.banking.inc.framework.services;

import com.banking.inc.framework.client.ApiClient;
import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.framework.models.request.auth.LoginRequest;
import io.restassured.response.Response;

public class LoginService {
    private final ApiClient apiClient;

    public LoginService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Response login(String email, String password) {
        LoginRequest payload = new LoginRequest(email, password);
        return apiClient.post(ConfigManager.required("loginPath"), payload);
    }
}