package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueNote;
import com.javarestassuredtemplate.requests.Issues.CriarIssueNoteRequest;
import com.javarestassuredtemplate.requests.Issues.DeletarIssueNoteRequest;
import com.javarestassuredtemplate.utils.GerarDados;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class DeletarIssueNoteTests extends TestBase {

    DeletarIssueNoteRequest deletarIssueNoteRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

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
        BuscarIssueDBSteps.inserirBugNote(idIssue,idBugNoteText);
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
