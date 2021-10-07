package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import com.sun.xml.xsom.impl.scd.Iterators;

import java.util.ArrayList;

public class BuscarProjetoDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/Projects/";

    public static void insereProjeto(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirProjeto.sql");
        query = query.replace("$name", GerarDados.nomeProjeto());
        query = query.replace("$file_path",GlobalStaticParameters.file_path);
        query = query.replace("$description", GlobalStaticParameters.description);
        DBUtils.getQueryResult(query);
    }

    public static void deletarProjeto(String id){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarProjeto.sql");
        query = query.replace("$idProjeto", id);
        DBUtils.getQueryResult(query);
    }


    public static String retornaIdProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdProjeto.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }

    public static String retornaIdPenultimoProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaIdPenultimoProjeto.sql");
        return DBUtils.getQueryResult(queryResultado).get(0);
    }


    public static ArrayList<String> retornaDadosProjeto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaDadosProjeto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosProjetoTodos(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornaDadosProjetoTodos.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

}
