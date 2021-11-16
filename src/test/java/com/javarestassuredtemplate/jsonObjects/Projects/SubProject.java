package com.javarestassuredtemplate.jsonObjects.Projects;

import com.javarestassuredtemplate.jsonObjects.Project;
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
        project = new Project(name);
    }


}
