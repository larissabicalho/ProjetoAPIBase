package com.javarestassuredtemplate.requests.Filters;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class RetornarFilterTodosRequest extends RequestRestBase {

    public RetornarFilterTodosRequest() {
        requestService = "/api/rest/filters/";
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }
}