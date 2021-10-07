package com.javarestassuredtemplate.requests.Config;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class ConfigOptionProjetoRequest extends RequestRestBase {
    public ConfigOptionProjetoRequest(String option) {
        requestService = "/api/rest/config?option=" + option;
        method = Method.GET;
        headers.put("Authorization", "cMyRDGhiz3P8Z4p1cip_0J38eUm1g1cV");
        headers.put("Content-Type", "application/json");
    }

}
