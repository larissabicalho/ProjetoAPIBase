package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.enums.Filter;
import io.restassured.http.Method;

public class BuscarIssueFilterRequest extends RequestRestBase {
    public BuscarIssueFilterRequest(String filter) {
        requestService = "/api/rest/issues?filter_id=" + filter;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
