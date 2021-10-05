package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.SubProject;
import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
import com.javarestassuredtemplate.requests.Project.CriarSubProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;


public class CriarSubProjetoTests extends TestBase {

    CriarSubProjetoRequest criarSubProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;

    @Test
    public void criarSubProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaIdPenultimoProjeto();
        String projectName = BuscarProjetoDBSteps.retornaIdNameUltimoIdProjeto().get(1);
        String projectIdSub = BuscarProjetoDBSteps.retornaIdNameUltimoIdProjeto().get(0);
        SubProject subProject = new SubProject();
        subProject.setDados(projectName);
        criarSubProjetoRequest = new CriarSubProjetoRequest(idProjeto);
        criarSubProjetoRequest.setJsonBodyUsingJavaObject(subProject);
        response = criarSubProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        response.statusLine(containsString("Subproject '"+projectIdSub+"' added to project '"+idProjeto+"'"));
       // response.contentType("Subproject '"+projectIdSub+"' added to project '"+idProjeto+"'");
        // descobrir como validar

     /*  response.body(
                "projects[0].id", equalTo(Integer.valueOf(idProjeto)),
                "projects[0].name", equalTo(BuscarProjetoDBSteps.retornaDadosProjeto().get(1)),
                "projects[0].description", equalTo( BuscarProjetoDBSteps.retornaDadosProjeto().get(2))
        );
  */
    }

}
