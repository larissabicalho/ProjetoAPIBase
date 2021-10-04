package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class BuscarTodosOsProjetosRequest extends RequestRestBase {
    public BuscarTodosOsProjetosRequest() {
        requestService = "/api/rest/projects/";
        method = Method.GET;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

}
