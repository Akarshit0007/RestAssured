package com.banking.inc.tests.smoke;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseApiTest {

    @Test(
        groups = {"smoke", "regression"}, 
        description = "Verifies that the configured API is reachable"
    )
    public void apiShouldBeReachable() {
        // Fetches health endpoint path from your properties file
        String path = ConfigManager.required("healthPath");
        
        Response response = apiClient.get(path);

        Assert.assertEquals(
            response.statusCode(), 
            200, 
            "The configured API health endpoint is unavailable"
        );
    }
}