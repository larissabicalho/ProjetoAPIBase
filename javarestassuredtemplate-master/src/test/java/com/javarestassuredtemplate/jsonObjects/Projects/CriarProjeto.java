package com.javarestassuredtemplate.jsonObjects.Projects;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Tag;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarProjeto {
    private long id;
    private String name = GlobalStaticParameters.projetoName;
    private Status status;
    private String description = GlobalStaticParameters.description;
    private boolean enabled = true;
    private String file_path = GlobalStaticParameters.file_path;
    private View_State view_state;


    public void setDados() {
        status = new Status();
        status.setId(10);
        status.setName("development");
        status.setLabel("development");
        view_state = new View_State();
        view_state.setId(10);
        view_state.setName("public");
        view_state.setLabel("public");
    }

}