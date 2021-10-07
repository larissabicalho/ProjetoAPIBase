package com.javarestassuredtemplate.requests.Lang;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class LangOptionsProjetoRequest extends RequestRestBase {
    public LangOptionsProjetoRequest(String option) {
        requestService = "/api/rest/lang?" + option;
        method = Method.GET;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

}
