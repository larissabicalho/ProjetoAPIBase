package com.javarestassuredtemplate.tests.Filters;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import com.javarestassuredtemplate.requests.Users.CriarUsuarioRequest;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class CriarFilterTests extends TestBase {

    DeletarUsuarioRequest deletarUsuarioRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void criarFilterComSucesso(){
        //Busca dados do usuario
        //fluxo
        BuscarUsuarioDBSteps.insereUsuario();
        String idUsuario = BuscarUsuarioDBSteps.retornaIdUsuario();


        deletarUsuarioRequest = new DeletarUsuarioRequest(idUsuario);
        response = deletarUsuarioRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);




    }
