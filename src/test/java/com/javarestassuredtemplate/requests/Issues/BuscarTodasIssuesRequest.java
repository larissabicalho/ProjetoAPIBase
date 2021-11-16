package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class BuscarTodasIssuesRequest extends RequestRestBase {
    public BuscarTodasIssuesRequest() {
        requestService = "/api/rest/issues?page_size=10&page=1";
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
