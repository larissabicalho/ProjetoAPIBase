package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarRelationships;
import com.javarestassuredtemplate.requests.Issues.DeletarRelationshipIssuesRequest;
import com.javarestassuredtemplate.requests.Issues.RelationshipIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class DeletarRelatiobshipIssuesProjetoTests extends TestBase {

    DeletarRelationshipIssuesRequest deletarRelationshipIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

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
        deletarRelationshipIssuesRequest = new DeletarRelationshipIssuesRequest(idsIssues.get(0),idRelationship);
        response = deletarRelationshipIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        ArrayList<String> idsTexto = BuscarIssueDBSteps.retornaIdsTexto();

            int n = 0;
            while (n <= idsIssues.size()-3) {
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));
            n = n + 3;
            }

           BuscarProjetoDBSteps.deletarProjeto(idProjeto);

      for(int v = 0; v < idsTexto.size(); v++) {
            BuscarIssueDBSteps.deletarTextoId(idsTexto.get(v));
       }

    }
}
