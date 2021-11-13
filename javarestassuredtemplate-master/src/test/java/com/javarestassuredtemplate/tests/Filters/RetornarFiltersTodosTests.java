package com.javarestassuredtemplate.tests.Filters;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarFilterDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Filters.RetornarFilterTodosRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;


public class RetornarFiltersTodosTests extends TestBase {

    RetornarFilterTodosRequest retornarFilterTodosRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void retornarFilterTodosComSucesso() {
        //Busca dados do usuario
        //fluxo
        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarFilterDBSteps.insereFilter(GlobalStaticParameters.user,idProjeto);
        ArrayList<String> idsFilters =  BuscarFilterDBSteps.retornarIdNameTodosFilter();
        retornarFilterTodosRequest = new RetornarFilterTodosRequest();
        response = retornarFilterTodosRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        int i = 0;
        int k = 2;
        int idPr = 2;
        int jName = 1;
        int kFilter =0;
        int mPossicoes = 0;

        while((idPr <= idsFilters.size() - 1) &&( jName <= idsFilters.size()-2 ) && (kFilter <= idsFilters.size()-3)){

            response.body(
                    "filters.id["+mPossicoes+"]" , equalTo(Integer.parseInt(idsFilters.get(kFilter))),
                    "filters.name["+mPossicoes+"]", equalTo(idsFilters.get(jName))
            );
            kFilter = kFilter + 3;
            jName = jName + 3;
            mPossicoes = mPossicoes +1;

        }


        while (i < idsFilters.size()) {
            BuscarFilterDBSteps.deletarFilter(idsFilters.get(i));
            BuscarProjetoDBSteps.deletarProjeto(idsFilters.get(k));
            k = k +3;
            i = i + 3;
        }

    }


}
