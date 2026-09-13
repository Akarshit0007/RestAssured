package com.banking.inc.tests.auth;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.framework.models.response.auth.CodeGenResponse;
import com.banking.inc.tests.auth.services.AuthService;
import com.banking.inc.tests.base.BaseApiTest;

import io.restassured.response.Response;

public class AuthenticationTest extends BaseApiTest {
    private AuthService authService;

    @BeforeClass 
    public void setupService(){
        this.authService = new AuthService(apiClient);
    }

    @Test (description = "Verify sucessfull end-to-email authentication flow With Code")
    public void verfiyEmailAuthenticationSuccessDuringNotRememberedPassword(){
        String userEmail = ConfigManager.required("email");
        // Request Code
        Response codeGenRawResponse = authService.requestVerificationCode(userEmail);
        Assert.assertEquals( codeGenRawResponse.statusCode(),200, "Code generation request failed.");

        CodeGenResponse codeGenData =  codeGenRawResponse.as(CodeGenResponse.class);
        Integer verificationCode = codeGenData.getVerificationCode();
        Assert.assertNotNull(verificationCode,"Verification code missing from response body.");

        Response codeVerifyResponse = authService.verifyCode(userEmail, verificationCode);

        if(codeVerifyResponse.statusCode() != 200){
            System.err.println("Verification failed! Response status: " + codeVerifyResponse.statusCode());
            System.err.println("Response body: " + codeVerifyResponse.asPrettyString());
        }
        Assert.assertEquals(codeVerifyResponse.statusCode(), 200, "Failed to verify authentication code");

    }
    
}
