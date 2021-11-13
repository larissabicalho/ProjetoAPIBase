package com.javarestassuredtemplate.tests.Filters;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarFilterDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Filters.DeletarFilterRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class DeletarFilterTests extends TestBase {

    DeletarFilterRequest deletarFilterRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    int statusCodeEsperadoErro = HttpStatus.SC_NOT_FOUND;
    GlobalStaticParameters globalStaticParameters;
    String mensagemErro = "HTTP/1.1 404 Filter not found";

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

    @Test
    public void deletarFilterComErro() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarFilterDBSteps.insereFilter(GlobalStaticParameters.user,idProjeto);
        String filterId = GlobalStaticParameters.idFilter;
        deletarFilterRequest = new DeletarFilterRequest(filterId);
        response = deletarFilterRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperadoErro);
        response.statusLine(mensagemErro);

        BuscarProjetoDBSteps.deletarProjeto(idProjeto);

    }



}
