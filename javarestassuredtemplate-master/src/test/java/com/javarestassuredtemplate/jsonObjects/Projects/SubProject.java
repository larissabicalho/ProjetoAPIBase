package com.javarestassuredtemplate.jsonObjects.Projects;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;

import com.javarestassuredtemplate.jsonObjects.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SubProject {
     Project project;
     private boolean inherit_parent = true;

    public void setDados(String name) {
        project = new Project();
        project.setName(name);
    }


}
