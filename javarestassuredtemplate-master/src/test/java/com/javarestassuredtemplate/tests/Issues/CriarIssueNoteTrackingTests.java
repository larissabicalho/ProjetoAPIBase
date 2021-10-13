package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueNote;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueNoteTracking;
import com.javarestassuredtemplate.requests.Issues.CriarIssueNoteRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class CriarIssueNoteTrackingTests extends TestBase {

    CriarIssueNoteRequest criarIssueNoteRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void criarIssueNoteTracking() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        CriarIssueNoteTracking criarIssueNoteTracking = new CriarIssueNoteTracking();
        criarIssueNoteTracking.setDados();
        criarIssueNoteRequest  = new CriarIssueNoteRequest(idIssue);
        criarIssueNoteRequest.setJsonBodyUsingJavaObject(criarIssueNoteTracking);
        response = criarIssueNoteRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "note.text", equalTo(criarIssueNoteTracking.getText()),
                "note.view_state.id", equalTo((int)criarIssueNoteTracking.getView_state().getId()),
                "note.view_state.name", equalTo(criarIssueNoteTracking.getView_state().getName()),
                "note.view_state.label", equalTo(criarIssueNoteTracking.getView_state().getLabel()),
                "note.time_tracking.duration", equalTo(criarIssueNoteTracking.getTime_tracking().getDuration())
        );

        BuscarIssueDBSteps.deletarIssue();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        String idNote = BuscarIssueDBSteps.retornarIdBugNote();
        String idNoteText = BuscarIssueDBSteps.retornarIdBugNoteText();
        BuscarIssueDBSteps.deletarNoteText(idNoteText);
        BuscarIssueDBSteps.deletarNote(idNote);
        BuscarIssueDBSteps.deletarTexto();

    }
}
