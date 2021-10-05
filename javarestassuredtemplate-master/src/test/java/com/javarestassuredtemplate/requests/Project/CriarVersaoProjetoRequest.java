package com.javarestassuredtemplate.requests.Project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.jsonObjects.Projects.Status;
import com.javarestassuredtemplate.jsonObjects.Projects.View_State;
import io.restassured.http.Method;


public class CriarVersaoProjetoRequest extends RequestRestBase {

    public CriarVersaoProjetoRequest(String idProjeto) {
        requestService = "/api/rest/projects/"+idProjeto+"/versions/";
        method = Method.POST;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
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

}