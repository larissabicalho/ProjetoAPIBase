package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class DeletarIssueRequest extends RequestRestBase {
    public DeletarIssueRequest(String issueId) {
        requestService = "/api/rest/issues/" + issueId;
        method = Method.DELETE;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
