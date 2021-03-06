package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.VersionProject;
import com.javarestassuredtemplate.requests.Projects.CriarVersaoProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;


public class CriarVersionProjetoTests extends TestBase {

    CriarVersaoProjetoRequest criarVersaoProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    int statusCodeEsperadoErro = HttpStatus.SC_BAD_REQUEST;
    String mensagemErroVersion = GlobalStaticParameters.mensagemErroVersion;

    @Test
    public void criarVersaoProjetoComSucesso() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
        VersionProject versionProject = new VersionProject();
        criarVersaoProjetoRequest = new CriarVersaoProjetoRequest(idProjeto);
        criarVersaoProjetoRequest.setJsonBodyUsingJavaObject(versionProject);
        response = criarVersaoProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        response.statusLine(containsString("Version created"));
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarProjetoDBSteps.deletarProjetoVersao(idProjeto);
    }

    @Test
    public void criarVersaoProjetoComErro() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = GlobalStaticParameters.idProjeto;
        VersionProject versionProject = new VersionProject();
        CriarVersaoProjetoRequest criarVersaoProjetoRequest = new CriarVersaoProjetoRequest(idProjeto);
        criarVersaoProjetoRequest.setJsonBodyUsingJavaObject(versionProject);
        response = criarVersaoProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(mensagemErroVersion);
    }

}
