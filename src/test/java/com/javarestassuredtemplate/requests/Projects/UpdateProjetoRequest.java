package com.javarestassuredtemplate.requests.Projects;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.UpdateProjeto;
import io.restassured.http.Method;

public class UpdateProjetoRequest extends RequestRestBase {

    public UpdateProjetoRequest(String projectId) {
        requestService = "/api/rest/projects/" + projectId;
        method = Method.PATCH;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(long id,
                                           String name,
                                           boolean enabled
    ) {
        jsonBody = new UpdateProjeto(id,
                name,
                enabled
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject) {
        jsonBody = jsonObject;
    }

}
