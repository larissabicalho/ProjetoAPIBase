package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Handler;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.jsonObjects.Issues.UpdateIssue;
import com.javarestassuredtemplate.jsonObjects.Project;
import com.javarestassuredtemplate.jsonObjects.Status;
import io.restassured.http.Method;

public class UpdateIssueRequest extends RequestRestBase {
    public UpdateIssueRequest(String issueId) {
        requestService = "/api/rest/issues/" + issueId;
        method = Method.PATCH;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String nameProject,
                                           String status){
        jsonBody = new UpdateIssue(new Handler(nameProject),
                new Status(status)

        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}


