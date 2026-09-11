package com.banking.inc.tests.auth;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.base.BaseApiTest;

import io.restassured.response.Response;

public class properLoginPath extends BaseApiTest {
    public int code = 0;
    
    @Test 
    public void sendingStringEmailFromToGetCode(){

        Map<String, String> requestBody = Map.of(
            "email", ConfigManager.required("email")
        );
        
        Response response = apiClient.post(ConfigManager.required("codeGenerate"), requestBody);
        Assert.assertEquals(response.statusCode(), 200);
        code = response.path("verificationCode");
        sendingEmailAndGenerateCode(code);
    }
    
    public void sendingEmailAndGenerateCode(int code){
        Map<String,Object> requestBody = Map.of(
            "email", ConfigManager.required("email"),
            "code", code
         );
            Response response = apiClient.post(ConfigManager.required("codeVerify"), requestBody);
             Assert.assertEquals(response.statusCode(), 200);

    }
    }
