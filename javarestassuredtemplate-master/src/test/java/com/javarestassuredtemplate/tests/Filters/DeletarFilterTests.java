package com.javarestassuredtemplate.tests.Filters;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarFilterDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Filters.DeletarFilterRequest;
import com.javarestassuredtemplate.requests.Filters.RetornarFilterRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class DeletarFilterTests extends TestBase {

    DeletarFilterRequest deletarFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void deletarFilterComSucesso() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarFilterDBSteps.insereFilter(GlobalStaticParameters.user,idProjeto);
        String filterId = BuscarFilterDBSteps.retornarIdNameFilter().get(0);
        deletarFilterRequest = new DeletarFilterRequest(filterId);
        response = deletarFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }


}
