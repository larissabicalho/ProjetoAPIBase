package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.AddAttachment;
import com.javarestassuredtemplate.requests.Issues.AttachFileIssuesRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.hamcrest.Matchers.containsString;


public class AddAttachmentIssueTests extends TestBase {

    AttachFileIssuesRequest attachFileIssuesRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;
    int statusCodeEsperadoErro = HttpStatus.SC_NOT_FOUND;
    String mensagemErroAttachment = GlobalStaticParameters.mensagemErroAttachment;

    @Test
    public void addFileComSucesso() throws IOException, SQLException {
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        AddAttachment addAttachment = new AddAttachment();
        addAttachment.setDados();
        attachFileIssuesRequest = new AttachFileIssuesRequest(idIssue);
        attachFileIssuesRequest.setJsonBodyUsingJavaObject(addAttachment);
        response = attachFileIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        response.statusLine(containsString("Issue File(s) Attached"));

        BuscarIssueDBSteps.deletarIssue();
        String idArquivo = BuscarIssueDBSteps.retornarIdAttachment();
        BuscarIssueDBSteps.deletarAttachment(idArquivo);
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();

    }

    @Test
    public void addFileComErro() throws IOException, SQLException {
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = GlobalStaticParameters.idIssue;
        AddAttachment addAttachment = new AddAttachment();
        addAttachment.setDados();
        attachFileIssuesRequest = new AttachFileIssuesRequest(idIssue);
        attachFileIssuesRequest.setJsonBodyUsingJavaObject(addAttachment);
        response = attachFileIssuesRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(mensagemErroAttachment);
        BuscarIssueDBSteps.deletarIssue();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarTexto();

    }
}
