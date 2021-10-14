package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class MonitorarIssueRequest extends RequestRestBase {
    public MonitorarIssueRequest(String issueId) {
        requestService = "/api/rest/issues/" + issueId +"/monitors";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }
}
