package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.enums.Filter;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueFilterRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class BuscarIssueFilterAssignedTests extends TestBase {

    BuscarIssueFilterRequest buscarIssueFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;

    @Test
    public void BuscarIssueFilterAssignedComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssueHandlerId(idProjeto, idTexto);

        String name = BuscarUsuarioDBSteps.retornaUsuarioAdm().get(0);
        String email = BuscarUsuarioDBSteps.retornaUsuarioAdm().get(1);
        buscarIssueFilterRequest = new BuscarIssueFilterRequest(String.valueOf(Filter.assigned));
        response = buscarIssueFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        ArrayList<String> idsIssues = BuscarIssueDBSteps.retornaDadosTodasIssuesAssigned();
        int iiD = 0;
        int jProject = 1;
        int kSummary = 2;
        int mPossicoes = 0;
        while ((iiD <= idsIssues.size() - 3) && (jProject <= idsIssues.size() - 2) && (kSummary <= idsIssues.size() - 1)) {
            response.body(
                    "issues.id[" + mPossicoes + "]", equalTo(Integer.valueOf(idsIssues.get(iiD))),
                    "issues.summary[" + mPossicoes + "]", equalTo(idsIssues.get(kSummary)),
                    "issues.project.id[" + mPossicoes + "]", equalTo(Integer.valueOf(idsIssues.get(jProject))),
                    "issues.handler.name[" + mPossicoes + "]", equalTo(name),
                    "issues.handler.email[" + mPossicoes + "]", equalTo(email)
            );
            iiD = iiD + 3;
            jProject = jProject + 3;
            kSummary = kSummary + 3;
            mPossicoes = mPossicoes + 1;

        }

        int n = 0;
        while (n <= idsIssues.size() - 3) {
            System.out.println("Issue" + idsIssues.get(n));
            String idTextoDelete = BuscarIssueDBSteps.retornarIdTexto(idsIssues.get(n));
            BuscarIssueDBSteps.deletarTextoId(idTextoDelete);
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));

            n = n + 3;
        }

        int p = 1;
        while (p <= idsIssues.size() - 2) {
            System.out.println("Projeto" + idsIssues.get(p));
            BuscarProjetoDBSteps.deletarProjeto(idsIssues.get(p));
            p = p + 3;
        }
    }
}
