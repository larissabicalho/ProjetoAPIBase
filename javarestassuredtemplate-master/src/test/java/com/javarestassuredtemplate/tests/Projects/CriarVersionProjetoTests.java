package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.jsonObjects.Projects.SubProject;
import com.javarestassuredtemplate.jsonObjects.Projects.VersionProject;
import com.javarestassuredtemplate.requests.Project.CriarSubProjetoRequest;
import com.javarestassuredtemplate.requests.Project.CriarVersaoProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;


public class CriarVersionProjetoTests extends TestBase {

    CriarVersaoProjetoRequest criarVersaoProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;

    @Test
    public void criarVersaoProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
        VersionProject versionProject = new VersionProject();
        CriarVersaoProjetoRequest criarVersaoProjetoRequest = new CriarVersaoProjetoRequest(idProjeto);
        criarVersaoProjetoRequest.setJsonBodyUsingJavaObject(versionProject);
        response = criarVersaoProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        response.statusLine(containsString("Version created"));
       // response.contentType("Subproject '"+projectIdSub+"' added to project '"+idProjeto+"'");

     /*  response.body(
                "projects[0].id", equalTo(Integer.valueOf(idProjeto)),
                "projects[0].name", equalTo(BuscarProjetoDBSteps.retornaDadosProjeto().get(1)),
                "projects[0].description", equalTo( BuscarProjetoDBSteps.retornaDadosProjeto().get(2))
        );
  */
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
    }

}
