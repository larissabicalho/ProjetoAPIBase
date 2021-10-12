package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.jsonObjects.Project;
import io.restassured.http.Method;

public class CriarIssuesRequest extends RequestRestBase {

    public CriarIssuesRequest(){
        requestService = "/api/rest/issues/";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String summary,
                                           String description,
                                           String nameCategory,
                                           String nameProject){
        jsonBody = new CriarIssue(summary,
                description,
                new Category(nameCategory),
                new Project(nameProject)
        );
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}


