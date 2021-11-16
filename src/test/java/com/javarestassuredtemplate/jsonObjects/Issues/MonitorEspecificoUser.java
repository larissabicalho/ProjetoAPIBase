package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonitorEspecificoUser {
    private Users[] users;

    public void setDados(String user, String username) {
        Users users1 = new Users();
        users1.setName(user);
        users1.setName_or_realname(username);
        users = new Users[]{users1};
    }

}


