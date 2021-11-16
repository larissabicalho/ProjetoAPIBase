package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Project;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarIssue {
    private String summary = GerarDados.sumarioIssue();
    private String description = GlobalStaticParameters.description;
    private Category category;
    private Project project;

    public void setDados(String projectName) {
        category = new Category(GlobalStaticParameters.nameCategory);
        project = new Project(projectName);
    }
}

