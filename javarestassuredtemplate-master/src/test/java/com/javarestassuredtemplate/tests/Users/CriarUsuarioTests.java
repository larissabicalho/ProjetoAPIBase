package com.javarestassuredtemplate.tests.Users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuario;
import com.javarestassuredtemplate.requests.Users.CriarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;



public class CriarUsuarioTests extends TestBase {

    CriarUsuarioRequest criarUsuarioRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void criarUsuarioSucesso(){
        //Busca dados do usuario
        CriarUsuario criarUsuario = new CriarUsuario();
        //fluxo
        criarUsuarioRequest = new CriarUsuarioRequest();
        criarUsuarioRequest.setJsonBodyUsingJavaObject(criarUsuario);
        response = criarUsuarioRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "user.name", equalTo(criarUsuario.getUsername()),
                "user.real_name", equalTo(criarUsuario.getReal_name()),
                 "user.email", equalTo(criarUsuario.getEmail())
        );

        String idUsuario = BuscarUsuarioDBSteps.retornaIdUsuario();
        BuscarUsuarioDBSteps.deletarUsuarioId(idUsuario);

    }


}
