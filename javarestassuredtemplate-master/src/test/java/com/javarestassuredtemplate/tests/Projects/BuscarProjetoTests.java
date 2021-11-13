package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class BuscarProjetoTests extends TestBase {

    BuscarProjetoRequest buscarProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    int statusCodeEsperadoErro = HttpStatus.SC_NOT_FOUND;
    String mensagemErro = "404 Project #11 not found";

    @Test
    public void buscarProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        buscarProjetoRequest = new BuscarProjetoRequest(idProjeto);
        response = buscarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

       response.body(
                "projects[0].id", equalTo(Integer.valueOf(idProjeto)),
                "projects[0].name", equalTo(BuscarProjetoDBSteps.retornaDadosProjeto().get(1))
        );

          BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }

    @Test
    public void buscarProjetoComErro(){
        //Busca dados do usuario
        //fluxo
        String idProjeto = GlobalStaticParameters.idProjeto;
        buscarProjetoRequest = new BuscarProjetoRequest(idProjeto);
        response = buscarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(Matchers.containsString(mensagemErro));

       /* response.body(
                "projects[0].id", equalTo(Integer.valueOf(idProjeto)),
                "projects[0].name", equalTo(BuscarProjetoDBSteps.retornaDadosProjeto().get(1)),
                "projects[0].description", equalTo( BuscarProjetoDBSteps.retornaDadosProjeto().get(2))
        );

*/

    }

}
