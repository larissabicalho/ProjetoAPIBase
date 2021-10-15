package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarFilterDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.UpdateIssue;
import com.javarestassuredtemplate.requests.Issues.BuscarFilterRequest;
import com.javarestassuredtemplate.requests.Issues.UpdateIssueRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class FilterIssueTests extends TestBase {

    BuscarFilterRequest buscarFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void BuscarFilterIssueComSucesso() {

        BuscarIssueDBSteps.insereFilterUrgente();
        String filterId = BuscarFilterDBSteps.retornarIdNameFilter().get(0);
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssueUrgente(idProjeto, idTexto);

        BuscarIssueDBSteps.insereTexto();
        String idTextoIssue2 = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssueUrgente2(idProjeto, idTextoIssue2);

        ArrayList<String> idsIssues = BuscarIssueDBSteps.retornarIssueFilter();
        ArrayList<String> idsTexto = BuscarIssueDBSteps.retornaIdsTexto();

        buscarFilterRequest = new BuscarFilterRequest(filterId);
        response = buscarFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        int iiD = 0;
        int jProject = 1;
        int kSummary = 2;
        int mPossicoes = 0;
        while(( iiD <= idsIssues.size()-3 ) && (jProject <= idsIssues.size()-2) && (kSummary <= idsIssues.size()-1)){
            response.body(
                    "issues.id["+mPossicoes+"]", equalTo(Integer.valueOf(idsIssues.get(iiD))),
                    "issues.summary["+mPossicoes+"]", equalTo(idsIssues.get(kSummary)),
                    "issues.project.id["+mPossicoes+"]", equalTo(Integer.valueOf(idsIssues.get(jProject))),
                    "issues.priority.id["+mPossicoes+"]", equalTo(GlobalStaticParameters.priority)
            );
            iiD = iiD + 3;
            jProject = jProject + 3;
            kSummary = kSummary + 3;
            mPossicoes = mPossicoes +1;

        }

        BuscarFilterDBSteps.deletarFilter(filterId);

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
        for(int v = 0; v < idsTexto.size(); v++) {
            BuscarIssueDBSteps.deletarTextoId(idsTexto.get(v));
        }



    }
}
