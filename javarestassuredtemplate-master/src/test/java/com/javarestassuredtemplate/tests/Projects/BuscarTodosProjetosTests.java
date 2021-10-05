package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
import com.javarestassuredtemplate.requests.Project.BuscarTodosOsProjetosRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class BuscarTodosProjetosTests extends TestBase {

   BuscarTodosOsProjetosRequest buscarTodosOsProjetosRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarProjetoComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        buscarTodosOsProjetosRequest = new BuscarTodosOsProjetosRequest();
        ArrayList<String> idsProjetos = BuscarProjetoDBSteps.retornaDadosProjetoTodos();
        response = buscarTodosOsProjetosRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        for (int i = idsProjetos.size(); i==0; i--) {
            response.body(
                    "projects["+i+"]..id", equalTo(Integer.valueOf(idsProjetos.get(i))),
                     "projects["+(i+1)+"]..name", equalTo(Integer.valueOf(idsProjetos.get(i+1)))
            );

        }
        int i =0;
        while (i < idsProjetos.size()) {
            BuscarProjetoDBSteps.deletarProjeto(idsProjetos.get(i));
            i = i + 2;
        }
    }
}
