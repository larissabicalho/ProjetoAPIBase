package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.requests.Issues.MonitorarIssueRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;


public class MonitorarIssueTests extends TestBase {

    MonitorarIssueRequest monitorarIssueRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;

    @Test
    public void BuscarIssueFilterMonitoredComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        monitorarIssueRequest = new MonitorarIssueRequest(idIssue);
        response = monitorarIssueRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issues.id[0]", equalTo(Integer.valueOf(BuscarIssueDBSteps.retornarIssueMonitor(idIssue).get(0))),
                "issues.summary[0]", equalTo(BuscarIssueDBSteps.retornarIssueMonitor(idIssue).get(2)),
                "issues.project.id[0]", equalTo(Integer.valueOf(BuscarIssueDBSteps.retornarIssueMonitor(idIssue).get(1)))
        );

        BuscarIssueDBSteps.deletarMonitoramento(idIssue);
        BuscarIssueDBSteps.deletarIssueId(idIssue);
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTextoId(idTexto);
    }

}
