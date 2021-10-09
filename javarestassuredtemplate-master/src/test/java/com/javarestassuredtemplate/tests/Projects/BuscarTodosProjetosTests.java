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
    public void buscarTodosProjetosComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        buscarTodosOsProjetosRequest = new BuscarTodosOsProjetosRequest();
        ArrayList<String> idsProjetos = BuscarProjetoDBSteps.retornaDadosProjetoTodos();

       response = buscarTodosOsProjetosRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        int i = 0;
        int jName = 1;
        int kProjeto =0;
        int mPossicoes = 0;
        while(( jName <= idsProjetos.size()-1 ) && (kProjeto <= idsProjetos.size()-2)){

            response.body(
                    "projects["+mPossicoes+"].id" , equalTo(Integer.parseInt(idsProjetos.get(kProjeto))),
                     "projects["+mPossicoes+"].name", equalTo(idsProjetos.get(jName))
            );
            kProjeto = kProjeto + 2;
            jName = jName + 2;
            mPossicoes = mPossicoes +1;

        }
        while (i < idsProjetos.size()) {
            BuscarProjetoDBSteps.deletarProjeto(idsProjetos.get(i));
            i = i + 2;
        }
    }
}
