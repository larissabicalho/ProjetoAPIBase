package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import com.sun.xml.xsom.impl.scd.Iterators;

import java.util.ArrayList;

public class BuscarProjetoDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/";

    public static void insereProjeto(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirProjeto.sql");
        query = query.replace("$name", GlobalStaticParameters.projetoName);
        query = query.replace("$file_path",GlobalStaticParameters.file_path);
        query = query.replace("$description", GlobalStaticParameters.description);
        DBUtils.getQueryResult(query);
    }

    public static String retornaIdProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdProjeto.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

    public static ArrayList<String> retornaDadosProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaDadosProjeto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaIdsProjetos(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdsProjetos.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

}
