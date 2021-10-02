package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

public class BuscarUsuarioDBSteps {
  //   System.getProperty("user.dir")+
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/";

    public static void insereUsuario(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirUsuario.sql");
        query = query.replace("$username", GerarDados.nomeUser());
        query = query.replace("$realname",GerarDados.fullName() );
        query = query.replace("$email", GerarDados.email());
        DBUtils.getQueryResult(query);
    }

    public static String retornaIdUsuario(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdUsuario.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

}