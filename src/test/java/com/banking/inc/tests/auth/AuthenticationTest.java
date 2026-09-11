package com.banking.inc.tests.auth;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.auth.services.AuthService;
import com.banking.inc.tests.base.BaseApiTest;

import io.restassured.response.Response;

public class AuthenticationTest extends BaseApiTest {
    private AuthService authService;

    @BeforeClass 
    public void setupService(){
        this.authService = new AuthService(apiClient);
    }

    @Test (description = "Verify sucessfull end-to-email authentication flow")
    public void verfiyEmailAuthenticationSuccessDuringNotRememberedPassword(){
        String userEmail = ConfigManager.required("email");
        // Request Code
        Response codeGenResponse = authService.requestVerificationCode(userEmail);
        Assert.assertEquals( codeGenResponse.statusCode(),200);

        Integer verificationCode = codeGenResponse.path("verificationCode");
        Assert.assertNotNull(verificationCode);

        Response codeVerifyResponse = authService.verifyCode(userEmail, verificationCode);
        Assert.assertEquals(codeVerifyResponse.statusCode(), 200, "Failed to verify authentication code");

    }
    
}
