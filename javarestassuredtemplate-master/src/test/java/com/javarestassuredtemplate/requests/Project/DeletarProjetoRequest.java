package com.javarestassuredtemplate.requests.Project;


import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class DeletarProjetoRequest extends RequestRestBase {
    public DeletarProjetoRequest(String projectId){
        requestService = "/api/rest/projects/"+projectId;
        method = Method.DELETE;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
    }
}
