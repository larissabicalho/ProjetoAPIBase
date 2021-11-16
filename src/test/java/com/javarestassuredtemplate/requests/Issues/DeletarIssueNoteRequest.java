package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class DeletarIssueNoteRequest extends RequestRestBase {
    public DeletarIssueNoteRequest(String issueId, String issueNote) {
        requestService = "/api/rest/issues/" + issueId + "/notes/" + issueNote;
        method = Method.DELETE;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
