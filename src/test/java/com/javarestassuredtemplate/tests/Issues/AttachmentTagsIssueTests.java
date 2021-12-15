package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Issues.AttachIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;


public class AttachmentTagsIssueTests extends TestBase {

    AttachIssuesRequest attachIssuesRequest;
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
        BuscarIssueDBSteps.insereTag();
        BuscarIssueDBSteps.insereTag();
        BuscarIssueDBSteps.insereTag();
        attachIssuesRequest = new AttachIssuesRequest(idIssue);
        attachIssuesRequest.setJsonBodyUsingJavaObject(Integer.parseInt(BuscarIssueDBSteps.retornarTags().get(0)),
                BuscarIssueDBSteps.retornarTags().get(1),
                Integer.valueOf(BuscarIssueDBSteps.retornarTags().get(2)), BuscarIssueDBSteps.retornarTags().get(3),
                Integer.valueOf(BuscarIssueDBSteps.retornarTags().get(4)), BuscarIssueDBSteps.retornarTags().get(5));
        response = attachIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issues.id[0]", equalTo(Integer.valueOf(idIssue)),
                "issues.description[0]", equalTo(BuscarIssueDBSteps.retornaDadosTexto().get(1)),
                "issues.tags[0].id[0]", equalTo(BuscarIssueDBSteps.retornarTags().get(0)),
                "issues.tags[0].name[0]", equalTo(BuscarIssueDBSteps.retornarTags().get(1)),
                "issues.tags[0].id[1]", equalTo(BuscarIssueDBSteps.retornarTags().get(2)),
                "issues.tags[0].name[1]", equalTo(BuscarIssueDBSteps.retornarTags().get(3)),
                "issues.tags[0].id[2]", equalTo(BuscarIssueDBSteps.retornarTags().get(4)),
                "issues.tags[0].name[2]", equalTo(BuscarIssueDBSteps.retornarTags().get(5))
        );


        BuscarIssueDBSteps.deletarIssueId(idIssue);
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTags();;
        BuscarIssueDBSteps.deletarTextoId(idTexto);
    }
}
