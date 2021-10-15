package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.AttachmentTag;
import com.javarestassuredtemplate.jsonObjects.Tags;
import io.restassured.http.Method;

public class AttachFileIssuesRequest extends RequestRestBase {

    public AttachFileIssuesRequest(String idIssue){
        requestService = "/api/rest/issues/"+idIssue+"/files";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }


    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}


