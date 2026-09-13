package com.banking.inc.tests.auth;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.auth.services.AuthService;
import com.banking.inc.tests.auth.services.LoginCodesService;
import com.banking.inc.tests.base.BaseApiTest;

import io.restassured.response.Response;

public class loginCodesTest extends BaseApiTest {

    private LoginCodesService loginCodesService;
     private AuthService authService;
    

 @BeforeClass(alwaysRun = true)
    public void setupService(){
        this.loginCodesService = new LoginCodesService(apiClient);
        this.authService = new AuthService(apiClient);
    }


    @Test( groups = {"smoke", "regression"}, description = "User With Valid Credentials Can Login")
    public void userCanLogin() {
         String userEmail = ConfigManager.required("email");
        String password =  ConfigManager.required("password");

        Response response = loginCodesService.Login(userEmail, password);

        Assert.assertEquals(response.statusCode(), 200);
        }


    @Test( groups = {"regression"}, description = "Wrong Email Cannot Login")
    public void wrongUserCannotLogin() {

        String userEmail = ConfigManager.required("Wemail");
        String password =  ConfigManager.required("password");

        Response response = loginCodesService.Login(userEmail, password);
        Assert.assertEquals(response.statusCode(), 404);
    }
    

    @Test(groups = {"smoke", "regression"},description = "A User Can Get and Genarate Verification Code")
    public void realUserCanGetVerificationCode(){

        String userEmail = ConfigManager.required("email");

        Response response = authService.requestVerificationCode(userEmail);
        Assert.assertEquals(response.statusCode(), 200);

    }
}