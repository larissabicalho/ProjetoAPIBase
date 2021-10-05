package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.jsonObjects.Projects.Status;
import com.javarestassuredtemplate.jsonObjects.Projects.VersionProject;
import com.javarestassuredtemplate.jsonObjects.Projects.View_State;
import io.restassured.http.Method;


public class CriarVersaoProjetoRequest extends RequestRestBase {

    public CriarVersaoProjetoRequest(String idProjeto) {
        requestService = "/api/rest/projects/"+idProjeto+"/versions/";
        method = Method.POST;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String name,
                                           String description,
                                           boolean released,
                                           boolean obsolete,
                                           String timestamp){
        jsonBody = new VersionProject(name,
                description,
                released,
                obsolete,
                timestamp
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}