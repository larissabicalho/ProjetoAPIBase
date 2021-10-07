package com.javarestassuredtemplate.requests.Project;


import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class DeletarProjetoRequest extends RequestRestBase {
    public DeletarProjetoRequest(String projectId){
        requestService = "/api/rest/projects/"+projectId;
        method = Method.DELETE;
        headers.put("Authorization", GlobalStaticParameters.token);
    }
}
