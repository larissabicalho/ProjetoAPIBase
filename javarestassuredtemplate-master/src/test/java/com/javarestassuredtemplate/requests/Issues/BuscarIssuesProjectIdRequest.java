package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class BuscarIssuesProjectIdRequest extends RequestRestBase {
    public BuscarIssuesProjectIdRequest(String idProjeto) {
        requestService = "/api/rest/issues?project_id=" + idProjeto;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
