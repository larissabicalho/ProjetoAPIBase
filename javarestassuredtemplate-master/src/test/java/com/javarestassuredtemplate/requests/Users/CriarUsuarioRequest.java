package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import io.restassured.http.Method;

public class CriarUsuarioRequest extends RequestRestBase {
    public CriarUsuarioRequest() {
        requestService = "/api/rest/users/";
        method = Method.POST;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");

    }
    public void setJsonBodyUsingJavaObject(CriarUsuario criarUsuario) {
        jsonBody = criarUsuario;

    }

}