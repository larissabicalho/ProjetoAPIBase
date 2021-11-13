package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Projects.BuscarProjetoRequest;
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
    String mensagemErroProjetoBusca = GlobalStaticParameters.mensagemErroProjetoBusca;

    @Test
    public void buscarProjetoComSucesso() {
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
    public void buscarProjetoComErro() {
        //Busca dados do usuario
        //fluxo
        String idProjeto = GlobalStaticParameters.idProjeto;
        buscarProjetoRequest = new BuscarProjetoRequest(idProjeto);
        response = buscarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(Matchers.containsString(mensagemErroProjetoBusca));

    }

}
