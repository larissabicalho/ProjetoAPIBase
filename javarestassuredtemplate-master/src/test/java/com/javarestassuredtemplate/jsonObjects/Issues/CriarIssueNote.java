package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Project;
import com.javarestassuredtemplate.jsonObjects.Projects.View_State;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarIssueNote {
    private String text = GerarDados.descricaoNote();
    private View_State view_state;

    public void setDados() {
        view_state = new View_State(GlobalStaticParameters.statusId, GlobalStaticParameters.viewStateName, GlobalStaticParameters.viewStateName);
    }
}

