package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class BuscarProjetoTests extends TestBase {

    BuscarProjetoRequest buscarProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo
        String projetoName = GlobalStaticParameters.projetoName;
        String file_path = GlobalStaticParameters.file_path;
        String description = GlobalStaticParameters.description;
        BuscarProjetoDBSteps.insereProjeto(projetoName, file_path, description);
        String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
        buscarProjetoRequest = new BuscarProjetoRequest(idProjeto);
        response = buscarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

       response.body(
                "projects[0].id", equalTo(idProjeto),
                "projects[0].name", equalTo(projetoName),
                "projects[0].description", equalTo(description)

        );

    }

}
