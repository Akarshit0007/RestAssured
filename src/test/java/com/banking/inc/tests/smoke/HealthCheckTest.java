package com.banking.inc.tests.smoke;

import com.banking.inc.framework.config.ConfigManager;
import com.banking.inc.tests.base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseApiTest {
    @Test(description = "Verifies that the configured API is reachable")
    public void apiShouldBeReachable() {
        Response response = apiClient.get(ConfigManager.required("healthPath"));

        Assert.assertEquals(response.statusCode(), 200, "The configured API health endpoint is unavailable");
    }
}