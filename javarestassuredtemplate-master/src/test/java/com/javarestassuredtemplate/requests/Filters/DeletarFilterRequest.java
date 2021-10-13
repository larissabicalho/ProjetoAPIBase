package com.javarestassuredtemplate.requests.Filters;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class DeletarFilterRequest extends RequestRestBase {

    public DeletarFilterRequest(String filterId) {
        requestService = "/api/rest/filters/" + filterId;
        method = Method.DELETE;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }
}