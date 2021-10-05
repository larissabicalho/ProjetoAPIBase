package com.javarestassuredtemplate.jsonObjects.Projects;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
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
    private String name = GerarDados.nomeUser();
    private Status status;
    private String description = GlobalStaticParameters.description;
    private boolean enabled = GlobalStaticParameters.enabled;
    private String file_path = GlobalStaticParameters.file_path;
    private View_State view_state;


    public void setDados() {
        status = new Status();
        status.setId(GlobalStaticParameters.statusId);
        status.setName(GlobalStaticParameters.statusName);
        status.setLabel(GlobalStaticParameters.statusName);
        view_state = new View_State();
        view_state.setId(GlobalStaticParameters.statusId);
        view_state.setName(GlobalStaticParameters.viewStateName);
        view_state.setLabel(GlobalStaticParameters.viewStateName);
    }

}