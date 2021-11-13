package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjetoDataDriven;
import com.javarestassuredtemplate.jsonObjects.Status;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuarioDataDriven;
import com.javarestassuredtemplate.jsonObjects.View_State;
import io.restassured.http.Method;


public class CriarProjetoRequest extends RequestRestBase {

    public CriarProjetoRequest() {
        requestService = "/api/rest/projects/";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }


    public void setJsonBodyUsingJavaObject(long id,
                                           String name,
                                           long idStatus,
                                           String nameStatus,
                                           String nameView,
                                           String labelStatus,
                                           String labelView,
                                           String description,
                                           boolean enabled,
                                           String file_path){
        jsonBody = new CriarProjeto(id,
                   name,
                   new Status(idStatus,nameStatus,labelStatus),
                   description,
                   enabled,
                   file_path,
                   new View_State(idStatus, nameView, labelView)
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

    public void setJsonBodyUsingJavaObject(CriarProjetoDataDriven criarProjetoDataDriven) {
        jsonBody = criarProjetoDataDriven;

    }
}