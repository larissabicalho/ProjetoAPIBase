package com.javarestassuredtemplate.defaultParameters;

import com.javarestassuredtemplate.enums.Names;
import com.javarestassuredtemplate.enums.Options;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class GlobalStaticParameters {
    //usersParameteres
    public static String password = "abc123";
    public static String token = "pE9b38G5lKIWus6BKsVJ87t-2w2gLqaj";

    //projectsParameteres
    public static String file_path = "/temp";
    public static String description = "Descricao" + " " + GerarDados.numeroAleatorio();
    public static String statusName = "development";
    public static long statusId = 10;
    public static String viewStateName = "public";
    public static boolean enabled = true;


    //projectsSub

    public static String versionName = "v1.0.0";
    public static String descriptionVersion = "Descricao" + " " + "Versao" + " " + GerarDados.numeroAleatorio();
    public static boolean released = true;
    public static boolean obsolete = false;
    public static String timestamp = GerarDados.dataVersion();

    //configOption
    public static String configOption = String.valueOf(Options.csv_separator);
    public static String configOptionValue = ",";
    public static String configsOptions = "option[]=" + Options.crypto_master_salt + "&option[]=" + Options.csv_separator + "&option[]=" + Options.status_colors + "&option[]=" + Options.does_not_exist + "&option[]=" + Options.status_enum_string + "";

    //LangOption
    public static String langOption = String.valueOf(Names.all_projects);
    public static String langsOptions = "string[]=" + Names.all_projects+ "&string[]=" + Names.does_not_exist + "&string[]=" + Names.status + "&string[]=" + Names.move_bugs+ "&string[]=" + Names.status_enum_string + "";

    //issuename

    public static String nameCategory = "General";


}

