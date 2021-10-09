package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueRequest;
import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class BuscarIssueTests extends TestBase {

    BuscarIssueRequest buscarIssueRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
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
        buscarIssueRequest = new BuscarIssueRequest(idIssue);
        response = buscarIssueRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issues.summary[0]", equalTo(BuscarIssueDBSteps.retornaDadosIssue().get(2)),
                "issues.description[0]", equalTo(BuscarIssueDBSteps.retornaDadosTexto().get(1)),
                "issues.project.id[0]", equalTo(Integer.valueOf(idProjeto))
        );


        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();
        BuscarIssueDBSteps.deletarIssue();
    }
}
