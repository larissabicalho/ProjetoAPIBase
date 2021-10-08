package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class BuscarIssueDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/Issues/";



    public static void deletarIssue(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "deletarIssue.sql");
        DBUtils.getQueryResult(queryResultado);
    }

}
