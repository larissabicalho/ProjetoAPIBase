package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueRequest;
import com.javarestassuredtemplate.requests.Issues.DeletarIssueRequest;
import com.javarestassuredtemplate.requests.Project.DeletarProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class DeletarIssueTests extends TestBase {

    DeletarIssueRequest deletarIssueRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarIssueComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        deletarIssueRequest = new DeletarIssueRequest(idIssue);
        response = deletarIssueRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();
        BuscarIssueDBSteps.deletarIssue();
    }
}
