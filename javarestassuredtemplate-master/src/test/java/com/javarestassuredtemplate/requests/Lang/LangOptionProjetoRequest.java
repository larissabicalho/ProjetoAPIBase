package com.javarestassuredtemplate.requests.Lang;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class LangOptionProjetoRequest extends RequestRestBase {
    public LangOptionProjetoRequest(String option) {
        requestService = "/api/rest/lang?string=" + option;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
