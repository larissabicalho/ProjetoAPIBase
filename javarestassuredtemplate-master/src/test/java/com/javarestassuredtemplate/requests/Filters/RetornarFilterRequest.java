package com.javarestassuredtemplate.requests.Filters;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class RetornarFilterRequest extends RequestRestBase {

    public RetornarFilterRequest(String filterId) {
        requestService = "/api/rest/filters/" + filterId;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }
}