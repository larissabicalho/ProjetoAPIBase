package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class BuscarUsuarioDBSteps {
    private static String queriesPath = "src/test/java/com/javarestassuredtemplate/queries/Users/";

    public static void insereUsuario() {
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirUsuario.sql");
        query = query.replace("$username", GerarDados.nomeUser());
        query = query.replace("$realname", GerarDados.fullName());
        query = query.replace("$email", GerarDados.email());
        DBUtils.getQueryResult(query);
    }

    public static String retornaIdUsuario() {
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdUsuario.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

    public static ArrayList<String> retornaUsuarioAdm() {
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarUsuarioAdm.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static void deletarUsuario() {
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarUsuario.sql");
        DBUtils.getQueryResult(query);
    }

    public static void deletarUsuarioId(String userId) {
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarUsuario.sql");
        query = query.replace("$idUser", userId);
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaUsuarioMonitor() {
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarUsuarioMonitorIssue.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static String retornaUsernameUsuario() {
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarUsuarioUpdateIssue.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

}
