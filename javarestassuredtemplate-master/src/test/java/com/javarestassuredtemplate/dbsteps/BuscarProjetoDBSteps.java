package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

public class BuscarProjetoDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/";

    public static void insereProjeto(String projetoName, String file_path, String description){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirProjeto.sql");
        query = query.replace("$name", projetoName);
        query = query.replace("$file_path",file_path);
        query = query.replace("$description", description );
        DBUtils.getQueryResult(query);
    }

    public static String retornaIdProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdProjeto.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

}
