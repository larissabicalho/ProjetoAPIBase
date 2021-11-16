package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueNote;
import com.javarestassuredtemplate.jsonObjects.View_State;
import io.restassured.http.Method;

public class CriarIssueNoteRequest extends RequestRestBase {
    public CriarIssueNoteRequest(String issueId) {
        requestService = "/api/rest/issues/" + issueId + "/notes";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String text,
                                           String nameViewState) {
        jsonBody = new CriarIssueNote(text,
                new View_State(nameViewState)
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject) {
        jsonBody = jsonObject;
    }

}


