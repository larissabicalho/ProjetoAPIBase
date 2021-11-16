package com.javarestassuredtemplate.jsonObjects.Users;
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
public class CriarUsuario {

    private String username;
    private String password = GlobalStaticParameters.password;
    private String real_name = GerarDados.fullName();
    private String email = GerarDados.email();

    public void setDados() {
        username = GerarDados.nomeUser();
    }

    public void setDadosJavascript() {
        username = GerarDados.nomeUserJavascript();
    }
}