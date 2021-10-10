package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.UpdateIssue;
import com.javarestassuredtemplate.requests.Issues.BuscarIssueRequest;
import com.javarestassuredtemplate.requests.Issues.UpdateIssueRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class UpdateIssueTests extends TestBase {

    UpdateIssueRequest updateIssueRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void UpdateIssueComSucesso() {
        BuscarUsuarioDBSteps.insereUsuario();
        String nameUser = BuscarUsuarioDBSteps.retornaUsernameUsuario();
        String idUsuario = BuscarUsuarioDBSteps.retornaIdUsuario();
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        UpdateIssue updateIssue = new UpdateIssue();
        updateIssue.setDados(nameUser);
        updateIssueRequest = new UpdateIssueRequest(idIssue);
        updateIssueRequest.setJsonBodyUsingJavaObject(updateIssue);
        response = updateIssueRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issues[0].id", equalTo(Integer.valueOf(idIssue)),
                "issues[0].handler.name", equalTo(updateIssue.getHandler().getName()),
                "issues[0].status.name", equalTo(updateIssue.getStatus().getName()),
                "issues[0].project.id", equalTo(Integer.valueOf(idProjeto))
        );



        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();
        BuscarUsuarioDBSteps.deletarUsuarioId(idUsuario);
        BuscarIssueDBSteps.deletarIssue();
    }
}
