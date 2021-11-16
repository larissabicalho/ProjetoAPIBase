package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.requests.Issues.CriarIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class CriarIssueTests extends TestBase {

    CriarIssuesRequest criarIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;

    @Test
    public void criarIssueComSucesso() {
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String nameProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(1);
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        CriarIssue criarIssue = new CriarIssue();
        criarIssue.setDados(nameProjeto);
        criarIssuesRequest = new CriarIssuesRequest();
        criarIssuesRequest.setJsonBodyUsingJavaObject(criarIssue);

        response = criarIssuesRequest.executeRequest();

        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issue.summary", equalTo(criarIssue.getSummary()),
                "issue.description", equalTo(criarIssue.getDescription()),
                "issue.project.name", equalTo(criarIssue.getProject().getName()),
                "issue.category.name", equalTo(criarIssue.getCategory().getName())
        );

        BuscarIssueDBSteps.deletarIssue();
        BuscarIssueDBSteps.deletarTexto();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }

}
