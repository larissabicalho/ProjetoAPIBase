package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class DeletarUsuarioRequest extends RequestRestBase {

    public DeletarUsuarioRequest(String userId){
        requestService = "/api/rest/users/"+userId;
        method = Method.DELETE;
        headers.put("Authorization", GlobalStaticParameters.token);
    }

}
