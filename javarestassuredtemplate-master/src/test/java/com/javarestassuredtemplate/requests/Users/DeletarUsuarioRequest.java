package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class DeletarUsuarioRequest extends RequestRestBase {

    public DeletarUsuarioRequest(String userId){
        requestService = "/api/rest/users/"+userId;
        method = Method.DELETE;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
    }

}
