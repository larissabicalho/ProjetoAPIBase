package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.requests.Issues.DeletarRelationshipIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class DeletarRelatiobshipIssuesProjetoTests extends TestBase {

    DeletarRelationshipIssuesRequest deletarRelationshipIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;

    @Test
    public void deletaRelatiobshipComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        BuscarIssueDBSteps.insereTexto();
        String idTextoIssue2 = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTextoIssue2);
        ArrayList<String> idsIssues = BuscarIssueDBSteps.retornaDadosTodasIssueIdProjeto(idProjeto);
        BuscarIssueDBSteps.inserirRelationship(idsIssues.get(0), idsIssues.get(3));
        String idRelationship = BuscarIssueDBSteps.retornarRelationship(idsIssues.get(0));
        deletarRelationshipIssuesRequest = new DeletarRelationshipIssuesRequest(idsIssues.get(0), idRelationship);
        response = deletarRelationshipIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        int n = 0;
        while (n <= idsIssues.size() - 3) {
            String idTextoDelete = BuscarIssueDBSteps.retornarIdTexto(idsIssues.get(n));
            BuscarIssueDBSteps.deletarTextoId(idTextoDelete);
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));
            n = n + 3;
        }

        int p = 1;
        while (p <= idsIssues.size() - 2) {
            BuscarProjetoDBSteps.deletarProjeto(idsIssues.get(p));
            p = p + 3;
        }

    }
}
