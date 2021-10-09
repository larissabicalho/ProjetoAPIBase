package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueRequest;
import com.javarestassuredtemplate.requests.Issues.BuscarTodasIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class BuscarTodasIssuesTests extends TestBase {

    BuscarTodasIssuesRequest buscarTodasIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarTodasIssuesComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        buscarTodasIssuesRequest = new BuscarTodasIssuesRequest();
        ArrayList<String> idsIssues = BuscarIssueDBSteps.retornaDadosTodasIssue();
       ArrayList<String> idsTexto = BuscarIssueDBSteps.retornaIdsTexto();
        response = buscarTodasIssuesRequest.executeRequest();
        //Validações
         response.log().all();
        response.statusCode(statusCodeEsperado);
        int iiD = 0;
        int jProject = 1;
        int kSummary = 2;
        int mPossicoes = 0;
        while(( iiD <= idsIssues.size()-3 ) && (jProject <= idsIssues.size()-2) && (kSummary <= idsIssues.size()-2)){
            response.body(
                    "issues.id["+mPossicoes+"]", equalTo(Integer.valueOf(BuscarIssueDBSteps.retornaDadosTodasIssue().get(iiD))),
                    "issues.summary["+mPossicoes+"]", equalTo(BuscarIssueDBSteps.retornaDadosTodasIssue().get(kSummary)),
                    "issues.project.id["+mPossicoes+"]", equalTo(Integer.valueOf(BuscarIssueDBSteps.retornaDadosTodasIssue().get(jProject)))
            );
            iiD = iiD + 3;
            jProject = jProject + 3;
            kSummary = kSummary + 3;
            mPossicoes = mPossicoes +1;

        }


       int n = 0;
        while (n <= idsIssues.size()-3) {
            BuscarIssueDBSteps.deletarIssueId(idsIssues.get(n));
            n = n + 3;
        }

      int p = 1;
      while (p <= idsIssues.size()-2){
           BuscarProjetoDBSteps.deletarProjeto(idsIssues.get(p));
            p = p + 3;
        }

        for(int j = 0; j < idsTexto.size(); j++) {
            BuscarIssueDBSteps.deletarTextoId(idsTexto.get(j));
     }

    }
}
