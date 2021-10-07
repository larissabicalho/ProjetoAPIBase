package com.javarestassuredtemplate.requests.Config;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class ConfigOptionProjetoRequest extends RequestRestBase {
    public ConfigOptionProjetoRequest(String option) {
        requestService = "/api/rest/config?option=" + option;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
