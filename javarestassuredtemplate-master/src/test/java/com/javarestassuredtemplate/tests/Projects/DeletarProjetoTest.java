package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Project.DeletarProjetoRequest;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DeletarProjetoTest extends TestBase {

    DeletarProjetoRequest deletarProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    int statusCodeEsperadoErro = HttpStatus.SC_BAD_REQUEST;
    String mensagemErro = "HTTP/1.1 400 Invalid project id.";

    @Test
    public void deletarProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
        deletarProjetoRequest = new DeletarProjetoRequest(idProjeto);
        response = deletarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

    }

    @Test
    public void deletarProjetoErro(){
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = GlobalStaticParameters.idProjetoDelete;
        deletarProjetoRequest = new DeletarProjetoRequest(idProjeto);
        response = deletarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(Matchers.containsString(mensagemErro));

    }
}
