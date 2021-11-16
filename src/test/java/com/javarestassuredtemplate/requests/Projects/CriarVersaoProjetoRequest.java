package com.javarestassuredtemplate.requests.Projects;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.VersionProject;
import io.restassured.http.Method;


public class CriarVersaoProjetoRequest extends RequestRestBase {

    public CriarVersaoProjetoRequest(String idProjeto) {
        requestService = "/api/rest/projects/" + idProjeto + "/versions/";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String name,
                                           String description,
                                           boolean released,
                                           boolean obsolete,
                                           String timestamp) {
        jsonBody = new VersionProject(name,
                description,
                released,
                obsolete,
                timestamp
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject) {
        jsonBody = jsonObject;
    }

}