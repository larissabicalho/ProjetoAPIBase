package com.javarestassuredtemplate.tests.Users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class DeletarUsuarioTests extends TestBase {

    DeletarUsuarioRequest deletarUsuarioRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    int statusCodeEsperadoErro = HttpStatus.SC_BAD_REQUEST;
    GlobalStaticParameters globalStaticParameters;
    String mensagemErro = "Invalid user id";

    @Test
    public void deletarUsuarioComSucesso(){
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

    @Test
    public void deletarUsuarioComErro(){
        //Busca dados do usuario
        //fluxo
        BuscarUsuarioDBSteps.insereUsuario();
        String idUsuario = GlobalStaticParameters.idUsuario;
        deletarUsuarioRequest = new DeletarUsuarioRequest(idUsuario);
        response = deletarUsuarioRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.body(
                "message", equalTo(mensagemErro)
        );

    }

}
