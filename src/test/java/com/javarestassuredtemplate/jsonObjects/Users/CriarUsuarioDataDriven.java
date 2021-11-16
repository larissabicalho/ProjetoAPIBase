package com.javarestassuredtemplate.jsonObjects.Users;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriarUsuarioDataDriven {

    private String username;
    private String password;
    private String real_name;
    private String email;

    public CriarUsuarioDataDriven(String username, String password, String real_name, String email){
        this.username = username;
        this.password = password;
        this.real_name = real_name;
        this.email = email;
    }
}