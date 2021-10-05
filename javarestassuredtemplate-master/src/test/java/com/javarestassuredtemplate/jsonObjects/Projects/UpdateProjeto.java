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
public class UpdateProjeto {
    private long id;
    private String name = "Update" + " "+ GerarDados.nomeProjeto();
    private boolean enabled = GlobalStaticParameters.enabled;
}
