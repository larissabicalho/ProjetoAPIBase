package com.javarestassuredtemplate.requests.Projects;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Project;
import com.javarestassuredtemplate.jsonObjects.Projects.*;
import io.restassured.http.Method;

public class CriarSubProjetoRequest extends RequestRestBase {
    public CriarSubProjetoRequest(String projetoId) {
        requestService = "/api/rest/projects/" + projetoId + "/subprojects";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(
            String subname,
            boolean inherit_parent) {
        jsonBody = new SubProject(new Project(subname),
                inherit_parent
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject) {
        jsonBody = jsonObject;
    }
}




