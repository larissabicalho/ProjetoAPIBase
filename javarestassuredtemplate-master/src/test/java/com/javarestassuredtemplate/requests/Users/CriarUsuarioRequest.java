package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuarioDataDriven;
import io.restassured.http.Method;

public class CriarUsuarioRequest extends RequestRestBase {

    public CriarUsuarioRequest(){
        requestService = "/api/rest/users/";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(CriarUsuario criarUsuario) {
        jsonBody = criarUsuario;

    }

    public void setJsonBodyUsingJavaObject(CriarUsuarioDataDriven criarUsuarioDataDriven) {
        jsonBody = criarUsuarioDataDriven;

    }

}