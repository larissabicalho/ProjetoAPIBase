package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.enums.Filter;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueFilterRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class BuscarIssueFilterReportedTests extends TestBase {

    BuscarIssueFilterRequest buscarIssueFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;

    @Test
    public void BuscarIssueFilterReportedComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        buscarIssueFilterRequest = new BuscarIssueFilterRequest(String.valueOf(Filter.reported));
        response = buscarIssueFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        ArrayList<String> idsIssues = BuscarIssueDBSteps.retornaDadosTodasIssuesReported();
        ArrayList<String> idsTexto = BuscarIssueDBSteps.retornaIdsTexto();
        int iiD = 0;
        int jProject = 1;
        int kSummary = 2;
        int mPossicoes = 0;
        while ((iiD <= idsIssues.size() - 3) && (jProject <= idsIssues.size() - 2) && (kSummary <= idsIssues.size() - 1)) {
            response.body(
                    "issues.id[" + mPossicoes + "]", equalTo(Integer.valueOf(idsIssues.get(iiD))),
                    "issues.summary[" + mPossicoes + "]", equalTo(idsIssues.get(kSummary)),
                    "issues.project.id[" + mPossicoes + "]", equalTo(Integer.valueOf(idsIssues.get(jProject)))
            );
            iiD = iiD + 3;
            jProject = jProject + 3;
            kSummary = kSummary + 3;
            mPossicoes = mPossicoes + 1;

        }

        int n = 0;
        while (n <= idsIssues.size() - 3) {
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));
            n = n + 3;
        }

        int p = 1;
        while (p <= idsIssues.size() - 2) {
            BuscarProjetoDBSteps.deletarProjeto(idsIssues.get(p));
            p = p + 3;
        }
        for (int v = 0; v < idsTexto.size(); v++) {
            BuscarIssueDBSteps.deletarTextoId(idsTexto.get(v));
        }

    }
}
