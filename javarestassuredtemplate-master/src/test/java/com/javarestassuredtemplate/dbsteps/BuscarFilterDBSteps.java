package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class BuscarFilterDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/Filters/";


    public static void insereFilter(String userId, String projectId){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirFilter.sql");
        query = query.replace("$user_id", userId);
        query = query.replace("$project_id", projectId);
        query = query.replace("$name", GerarDados.filterName());
        query = query.replace("$filter_string", GerarDados.filter_String());
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornarIdNameFilter(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarFilter.sql");
        return DBUtils.getQueryResult(query);
    }

    public static void deletarFilter(String filterId){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarFilter.sql");
        query = query.replace("$idFilter", filterId);
        DBUtils.getQueryResult(query);
    }


    public static ArrayList<String> retornarIdNameTodosFilter(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarTodosFilter.sql");
        return DBUtils.getQueryResult(query);
    }

}
