package com.javarestassuredtemplate.defaultParameters;

import com.javarestassuredtemplate.utils.GerarDados;

public class GlobalStaticParameters {
    //usersParameteres
    public static String password = "abc123";

    //projectsParameteres
    public static String file_path = "/temp";
    public static String  description = "Descricao" +" " + GerarDados.numeroAleatorio();
    public static String statusName = "development";
    public static long statusId= 10;
    public static String viewStateName = "public";
    public static boolean enabled = true;


    //projectsSub

    public static String versionName = "v1.0.0";
    public static String  descriptionVersion = "Descricao"+" " +"Versao"+ " " +GerarDados.numeroAleatorio();
    public static boolean released = true;
    public static boolean obsolete = false;
    public static String timestamp = GerarDados.dataVersion();

}