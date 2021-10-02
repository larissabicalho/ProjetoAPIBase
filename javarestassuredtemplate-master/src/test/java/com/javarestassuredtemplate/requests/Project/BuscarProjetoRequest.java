package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class BuscarProjetoRequest extends RequestRestBase {
    public BuscarProjetoRequest(String projectId) {
        requestService = "/api/rest/projects/" + projectId;
        method = Method.GET;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

}
