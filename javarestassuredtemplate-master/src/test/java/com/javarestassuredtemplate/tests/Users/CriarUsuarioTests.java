package com.javarestassuredtemplate.tests.Users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import com.javarestassuredtemplate.requests.Users.CriarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


@Test
public class CriarUsuarioTests extends TestBase {

    CriarUsuarioRequest criarUsuarioRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    public void criarUsuarioSucesso(){
        //Busca dados do usuario
        CriarUsuario buscaDadosUsuario = new CriarUsuario();
        //fluxo
        criarUsuarioRequest = new CriarUsuarioRequest();
        criarUsuarioRequest.setJsonBodyUsingJavaObject(buscaDadosUsuario);
        response = criarUsuarioRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        

    }


}
