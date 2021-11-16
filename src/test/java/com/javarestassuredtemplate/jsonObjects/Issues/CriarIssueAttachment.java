package com.javarestassuredtemplate.jsonObjects.Issues;


import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import java.io.*;
import java.sql.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarIssueAttachment {
    private String summary = GerarDados.sumarioIssue();
    private String description = GlobalStaticParameters.description;
    private Category category;
    private Project project;
    private Custom_Field custom_field;
    private Files[] files;



    public void setDados(String projectName, long idProjeto, long idField) throws IOException, SQLException {
        category = new Category(GlobalStaticParameters.idCategory, GlobalStaticParameters.nameCategory);
        project = new Project(idProjeto, projectName);
        custom_field = new Custom_Field();
        Field field = new Field();
        field.setId(idField);
        field.setName(GlobalStaticParameters.nameField);
        custom_field.setField(field);
        custom_field.setValue(GlobalStaticParameters.valueCustomField);
        Files file1 = new Files();
        file1.setName(GerarDados.filename());
        file1.setContent(GeneralUtils.encodeFileToBase64Binary("file.png"));
        files = new Files[]{file1};
    }
}


