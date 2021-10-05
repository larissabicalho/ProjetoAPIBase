package com.javarestassuredtemplate.tests.Users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import com.javarestassuredtemplate.requests.Users.RetornarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class RetornarUsuarioTests extends TestBase {

    DeletarUsuarioRequest deletarUsuarioRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void retornarAdmComSucesso(){

        RetornarUsuarioRequest retornarUsuarioRequest = new RetornarUsuarioRequest();
        response = retornarUsuarioRequest.executeRequest();
        String name =  BuscarUsuarioDBSteps.retornaUsuarioAdm().get(0);
        String email =  BuscarUsuarioDBSteps.retornaUsuarioAdm().get(1);

        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);


       response.body(
                "name", equalTo(name),
                "email", equalTo(email)
        );

    }



}
