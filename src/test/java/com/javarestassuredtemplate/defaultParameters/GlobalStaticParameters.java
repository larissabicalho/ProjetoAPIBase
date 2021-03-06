package com.javarestassuredtemplate.defaultParameters;

import com.javarestassuredtemplate.enums.Names;
import com.javarestassuredtemplate.enums.Options;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class GlobalStaticParameters {
    //usersParameteres
    public static String password = "abc123";
    public static String token = "04alsw4AlRg_yj5pCVY0ig3Ryf9xc-SG";

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

    //issueUpdate

    public static String nameCategory = "General";
    public static String statusIssue = "assigned";

    //issue attachment
    public static long idCategory =5;
    public static String nameField = "The City";
    public static String valueCustomField = "Seattle";

    //issuenotes
    public static String time = "00:30";

    //filter
    public static String user = "1";

    //relationships

    public static String nameRelationships = "related-to";

    public static String message = "Relationship added";

    //filters
    public static int priority = 50;

    //deletarUsuario

    public static String idUsuario = "00X";

    //deletarProjeto

    public static String idProjeto = "11x";

    //idFilter
    public static String idFilter = "22x";

    //Config
    public static String config = "ccc";

    //idIssue
    public static String idIssue = "000233";

    public static String idProjetoDelete = "xxx";

    // mensagens erro
    public static String mensagemErroUsuario = "Invalid user id";
    public static String messagemErroAdm = "Username 'administrator' already used.";
    public static String mensagemErroProjeto = "HTTP/1.1 400 Invalid project id.";
    public static String mensagemErroVersion = "HTTP/1.1 400 'project_id' must be numeric";
    public static String mensagemErroProjetoBusca = "404 Project #11 not found";
    public static String mensagemErroIssue = "HTTP/1.1 404 Issue #233 not found";
    public static String mensagemErroIssueBuscar = "HTTP/1.1 404 Issue #233 not found";
    public static String mensagemErroAttachment = "HTTP/1.1 404 Issue #233 not found";
    public static String mensagemErroFilter = "HTTP/1.1 404 Filter not found";

}

