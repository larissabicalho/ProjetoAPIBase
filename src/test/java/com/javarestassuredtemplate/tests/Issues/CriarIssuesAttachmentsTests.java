package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.CriarIssueAttachment;
import com.javarestassuredtemplate.requests.Issues.CriarIssuesAttachmentsRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CriarIssuesAttachmentsTests extends TestBase {

    CriarIssuesAttachmentsRequest criarIssuesAttachmentsRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;

    @Test
    public void criarIssueAttachmentComSucesso() throws IOException, SQLException {
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String nameProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(1);
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.inserirCustom_Field(GlobalStaticParameters.nameField);
        long idCustom_Field = Integer.valueOf(BuscarIssueDBSteps.retornarCustom_FieldId());
        CriarIssueAttachment criarIssueAttachment = new CriarIssueAttachment();
        criarIssueAttachment.setDados(nameProjeto, Integer.valueOf(idProjeto), idCustom_Field);
        criarIssuesAttachmentsRequest = new CriarIssuesAttachmentsRequest();
        criarIssuesAttachmentsRequest.setJsonBodyUsingJavaObject(criarIssueAttachment);
        response = criarIssuesAttachmentsRequest.executeRequest();

        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issue.project.id", equalTo(Integer.valueOf(idProjeto)),
                "issue.project.name", equalTo(nameProjeto),
                "issue.attachments.id[0]", equalTo(Integer.valueOf(BuscarIssueDBSteps.retornarIdAttachment())),
                "issue.history.message[1]", containsString("File Added:")
        );

        BuscarIssueDBSteps.deletarIssue();
        BuscarIssueDBSteps.deletarCustom_Field();
        String idArquivo = BuscarIssueDBSteps.retornarIdAttachment();
        BuscarIssueDBSteps.deletarAttachment(idArquivo);
        BuscarIssueDBSteps.deletarTexto();
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }

}
