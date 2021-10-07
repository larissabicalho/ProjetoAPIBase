package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Project;
import com.javarestassuredtemplate.jsonObjects.Projects.*;
import io.restassured.http.Method;

public class CriarSubProjetoRequest extends RequestRestBase {
    public CriarSubProjetoRequest(String projetoId) {
        requestService = "/api/rest/projects/"+projetoId+"/subprojects";
        method = Method.POST;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(
                                           String subname,
                                           boolean inherit_parent){
        jsonBody = new SubProject(new Project(subname),
                inherit_parent
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }
}




