package com.javarestassuredtemplate.defaultParameters;

import com.javarestassuredtemplate.utils.GerarDados;

public class GlobalStaticParameters {
    //usersParameteres
    public static String username = "teste2";
    public static String password = "abc123";
    public static String real_name = "Marcos Joao";
    public static String email = "LucasYY@teste.com";

    public static String projetoName = "Projeto" + GerarDados.nomeUser();
    public static String file_path = "/temp";
    public static String  description = "Descricao" + GerarDados.nomeUser();

}