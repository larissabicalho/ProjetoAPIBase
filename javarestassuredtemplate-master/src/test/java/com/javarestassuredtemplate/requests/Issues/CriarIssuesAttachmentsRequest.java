package com.javarestassuredtemplate.requests.Issues;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.primitives.Bytes;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueAttachment;
import io.restassured.http.Method;

import org.mariadb.jdbc.MariaDbBlob;

import java.io.File;
import java.sql.Blob;

public class CriarIssuesAttachmentsRequest extends RequestRestBase {

    public CriarIssuesAttachmentsRequest() {
        requestService = "/api/rest/issues/";
        method = Method.POST;
        headers.put("Authorization", GlobalStaticParameters.token);
        headers.put("Content-Type", "application/json");
    }

    public void setJsonBodyUsingJavaObject(String summary,
                                           String description,
                                           long idCategory,
                                           String nameCategory,
                                           long idProjeto,
                                           String nameProject,
                                           long idField,
                                           String nameField,
                                           String valueField,
                                           String nameFile,
                                           String contentFile) {
        jsonBody = new CriarIssueAttachment(summary,
                description,
                new Category(idCategory, nameCategory),
                new Project(idProjeto, nameProject),
                new Custom_Field(new Field(idField, nameField), valueField),
                new Files[]{new Files(nameFile, contentFile)});
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject) {
        jsonBody = jsonObject;
    }

}


