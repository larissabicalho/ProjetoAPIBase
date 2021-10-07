package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import io.restassured.http.Method;

public class CriarIssuesRequest extends RequestRestBase {

    public CriarIssuesRequest(){
        requestService = "/api/rest/users/";
        method = Method.POST;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

    /*public void setJsonBodyUsingJavaObject(CriarIssues criarIssues) {
        jsonBody = criarIssues; */

}


