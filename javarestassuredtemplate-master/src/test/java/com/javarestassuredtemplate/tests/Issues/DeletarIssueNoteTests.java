package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssue;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueNote;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueRequest;
import com.javarestassuredtemplate.requests.Issues.CriarIssueNoteRequest;
import com.javarestassuredtemplate.requests.Issues.CriarIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class CriarIssueNoteTests extends TestBase {

    CriarIssueNoteRequest criarIssueNoteRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void criarIssueNote() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        CriarIssueNote criarIssueNote = new CriarIssueNote();
        criarIssueNote.setDados();
        criarIssueNoteRequest  = new CriarIssueNoteRequest(idIssue);
        criarIssueNoteRequest.setJsonBodyUsingJavaObject(criarIssueNote);
        response = criarIssueNoteRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "note.text", equalTo(criarIssueNote.getText()),
                "note.view_state.id", equalTo((int)criarIssueNote.getView_state().getId()),
                "note.view_state.name", equalTo(criarIssueNote.getView_state().getName()),
                "note.view_state.label", equalTo(criarIssueNote.getView_state().getLabel())
        );

        BuscarIssueDBSteps.deletarIssue();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        String idNote = BuscarIssueDBSteps.retornarIdBugNote();
        BuscarIssueDBSteps.deletarNote(idNote);
        BuscarIssueDBSteps.deletarTexto();
    }
}
