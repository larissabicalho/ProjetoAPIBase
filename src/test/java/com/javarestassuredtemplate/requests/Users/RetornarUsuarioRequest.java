package com.javarestassuredtemplate.requests.Users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class RetornarUsuarioRequest extends RequestRestBase {

    public RetornarUsuarioRequest() {
        requestService = "/api/rest/users/me";
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
