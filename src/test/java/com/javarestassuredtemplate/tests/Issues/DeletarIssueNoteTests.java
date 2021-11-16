package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.requests.Issues.DeletarIssueNoteRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class DeletarIssueNoteTests extends TestBase {

    DeletarIssueNoteRequest deletarIssueNoteRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;

    @Test
    public void deletarIssueNote() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        BuscarIssueDBSteps.inserirBugNoteText();
        String idBugNoteText = BuscarIssueDBSteps.retornarIdBugNoteText();
        BuscarIssueDBSteps.inserirBugNote(idIssue, idBugNoteText);
        String idBugNote = BuscarIssueDBSteps.retornarIdBugNote();
        deletarIssueNoteRequest = new DeletarIssueNoteRequest(idIssue, idBugNote);
        response = deletarIssueNoteRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

     /*   response.body(
                "note.text", equalTo(criarIssueNote.getText()),
                "note.view_state.id", equalTo((int)criarIssueNote.getView_state().getId()),
                "note.view_state.name", equalTo(criarIssueNote.getView_state().getName()),
                "note.view_state.label", equalTo(criarIssueNote.getView_state().getLabel())
        );*/

        BuscarIssueDBSteps.deletarIssue();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();
    }
}
