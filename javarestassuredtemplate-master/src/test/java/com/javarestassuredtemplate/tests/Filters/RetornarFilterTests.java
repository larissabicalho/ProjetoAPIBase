package com.javarestassuredtemplate.tests.Filters;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarFilterDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Filters.RetornarFilterRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RetornarFilterTests extends TestBase {

    RetornarFilterRequest retornarFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void retornarFilterComSucesso() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarFilterDBSteps.insereFilter(GlobalStaticParameters.user,idProjeto);
        String filterId = BuscarFilterDBSteps.retornarIdNameFilter().get(0);
        retornarFilterRequest = new RetornarFilterRequest(filterId);
        response = retornarFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "filters.id[0]", equalTo(Integer.valueOf(filterId)),
                "filters.name[0]", equalTo(BuscarFilterDBSteps.retornarIdNameFilter().get(1)),
                "filters.project.id[0]", equalTo(Integer.valueOf(idProjeto))
        );

        BuscarFilterDBSteps.deletarFilter(filterId);
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }

    @Test
    public void retornarFilterComErro() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarFilterDBSteps.insereFilter(GlobalStaticParameters.user,idProjeto);
        String filterId = GlobalStaticParameters.idFilter;
        retornarFilterRequest = new RetornarFilterRequest(filterId);
        response = retornarFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        response.body(
                "filters.name[0]", equalTo(null)
        );
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }


}
