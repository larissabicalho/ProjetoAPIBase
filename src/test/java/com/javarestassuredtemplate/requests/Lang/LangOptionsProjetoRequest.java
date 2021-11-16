package com.javarestassuredtemplate.requests.Lang;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class LangOptionsProjetoRequest extends RequestRestBase {
    public LangOptionsProjetoRequest(String option) {
        requestService = "/api/rest/lang?" + option;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
