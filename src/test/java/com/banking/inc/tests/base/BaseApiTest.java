package com.banking.inc.tests.base;

import com.banking.inc.framework.client.ApiClient;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {
    protected ApiClient apiClient;

    @BeforeClass(alwaysRun = true)
    public void setUpApiClient() {
        apiClient = new ApiClient();
    }
}