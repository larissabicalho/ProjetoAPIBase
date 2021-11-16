package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import io.restassured.http.Method;

public class BuscarFilterRequest extends RequestRestBase {
    public BuscarFilterRequest(String filterId) {
        requestService = "/api/rest/issues?filter_id=" + filterId;
        method = Method.GET;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

}
