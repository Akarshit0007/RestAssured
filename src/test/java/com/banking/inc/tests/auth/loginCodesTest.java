package com.banking.inc.tests.auth;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.base.BaseApiTest;

import io.restassured.response.Response;

public class loginCodesTest extends BaseApiTest {

    @Test 
    public void userCanLogin() {
        Map<String, String> requestBody = Map.of(
            "email", ConfigManager.required("email"),
            "password", ConfigManager.required("password")
        );

        Response response = apiClient.post(ConfigManager.required("loginPath"), requestBody);

        Assert.assertEquals(response.statusCode(), 200);
        }

    @Test
    public void wrongUserCannotLogin() {
        Map<String, String> requestBody = Map.of(
            "Wemail", ConfigManager.required("email"),
            "password", ConfigManager.required("password")
        );
        Response response = apiClient.post(ConfigManager.required("loginPath"), requestBody);
        Assert.assertEquals(response.statusCode(), 404);
    }
    
    @Test 
    public void realUserCanGetVerificationCode(){
        Map<String, String> requestBody = Map.of(
            "email", ConfigManager.required("email"),
            "password", ConfigManager.required("password")
        );
        Response response = apiClient.post(ConfigManager.required("codeVerify"), requestBody);
        Assert.assertEquals(response.statusCode(), 200);

    }
}