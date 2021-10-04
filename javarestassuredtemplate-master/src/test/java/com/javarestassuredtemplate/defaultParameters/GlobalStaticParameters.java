package com.javarestassuredtemplate.defaultParameters;

import com.javarestassuredtemplate.utils.GerarDados;

public class GlobalStaticParameters {
    //usersParameteres
    public static String password = "abc123";

    //projectsParameteres
    public static String projetoName = "Projeto Teste Larissa" + GerarDados.numeroAleatorio();
    public static String file_path = "/temp";
    public static String  description = "Descricao" +"" + GerarDados.numeroAleatorio();
    public static String statusName = "development";
    public static long statusId= 10;
    public static String viewStateName = "public";


}