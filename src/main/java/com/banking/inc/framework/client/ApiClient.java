package com.banking.inc.framework.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {
    private final RequestSpecification requestSpecification;

    public ApiClient() {
        this(RequestSpecFactory.defaultSpec());
    }

    public ApiClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response get(String path) {
        return given().spec(requestSpecification).when().get(path);
    }

    public Response post(String path, Object body) {
        return given().spec(requestSpecification).body(body).when().post(path);
    }
}