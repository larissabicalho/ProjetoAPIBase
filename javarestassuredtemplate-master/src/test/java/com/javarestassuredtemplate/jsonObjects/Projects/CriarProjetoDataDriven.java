package com.javarestassuredtemplate.jsonObjects.Projects;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Status;
import com.javarestassuredtemplate.jsonObjects.View_State;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarProjetoDataDriven {

    private long id;
    private String name;
    private Status status;
    private String description;
    private boolean enabled;
    private String file_path;
    private View_State view_state;


    public CriarProjetoDataDriven(String name, long statusId, String statusName,String description, boolean enabled, String file_path,long statusIdView, String statusNameView) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.file_path = file_path;
        status = new Status(statusId,statusName,statusName);
        view_state = new View_State(statusIdView, statusNameView, statusNameView);
    }

}