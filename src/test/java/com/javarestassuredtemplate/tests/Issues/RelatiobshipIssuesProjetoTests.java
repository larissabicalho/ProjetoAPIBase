package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarRelationships;
import com.javarestassuredtemplate.requests.Issues.RelationshipIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class RelatiobshipIssuesProjetoTests extends TestBase {

    RelationshipIssuesRequest relationshipIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;

    @Test
    public void relatiobshipComSucesso() {
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

        CriarRelationships criarRelationships = new CriarRelationships();
        criarRelationships.setDados(Integer.valueOf(idsIssues.get(3)));
        relationshipIssuesRequest = new RelationshipIssuesRequest(idsIssues.get(0));
        relationshipIssuesRequest.setJsonBodyUsingJavaObject(criarRelationships);
        response = relationshipIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        ArrayList<String> idsTexto = BuscarIssueDBSteps.retornaIdsTexto();

        response.body(
                "issue.history.message[0]", equalTo(GlobalStaticParameters.message),
                "issue.history.issue.id[0]", equalTo(Integer.valueOf(idsIssues.get(3)))

        );

        BuscarIssueDBSteps.deletarRelationship(idsIssues.get(0));
        int n = 0;
        while (n <= idsIssues.size() - 3) {
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));
            n = n + 3;
        }

        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

        for (int v = 0; v < idsTexto.size(); v++) {
            BuscarIssueDBSteps.deletarTextoId(idsTexto.get(v));
        }

    }
}
