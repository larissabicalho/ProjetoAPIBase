package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import io.restassured.http.Method;

public class RetornarUsuarioRequest extends RequestRestBase {

    public RetornarUsuarioRequest(){
        requestService = "/api/rest/users/me";
        method = Method.GET;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

}
