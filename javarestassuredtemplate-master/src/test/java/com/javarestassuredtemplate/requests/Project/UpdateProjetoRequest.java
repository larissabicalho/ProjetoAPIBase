package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.jsonObjects.Projects.Status;
import com.javarestassuredtemplate.jsonObjects.Projects.UpdateProjeto;
import com.javarestassuredtemplate.jsonObjects.Projects.View_State;
import io.restassured.http.Method;

public class UpdateProjetoRequest extends RequestRestBase {

    public UpdateProjetoRequest(String projectId) {
        requestService = "/api/rest/projects/" + projectId;
        method = Method.PATCH;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(long id,
                                           String name,
                                           boolean enabled
                                         ){
        jsonBody = new UpdateProjeto(id,
                name,
                enabled
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}
