package com.javarestassuredtemplate.requests.Issues;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.jsonObjects.Issues.AttachmentTag;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueAttachment;
import io.restassured.http.Method;
import org.testng.xml.dom.Tag;

public class AttachIssuesRequest extends RequestRestBase {

    public AttachIssuesRequest(String idIssue){
        requestService = "/api/rest/issues/"+idIssue+"/tags";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }
    public void setJsonBodyUsingJavaObject(long id, String name, long id2, String name2, long id3, String name3){
        jsonBody = new AttachmentTag(new Tags[]{new Tags(id, name),new Tags(id2,name2), new Tags(id3, name3)});
    }


    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }

}


