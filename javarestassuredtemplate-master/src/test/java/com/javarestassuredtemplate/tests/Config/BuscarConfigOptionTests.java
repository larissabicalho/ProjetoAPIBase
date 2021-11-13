package com.javarestassuredtemplate.tests.Config;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Config.ConfigOptionProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class BuscarConfigOptionTests extends TestBase {

    ConfigOptionProjetoRequest configOptionProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarConfigComSucesso(){
        //Busca dados do usuario
        //fluxo
        String config = GlobalStaticParameters.configOption;
        configOptionProjetoRequest = new ConfigOptionProjetoRequest(config);
        response = configOptionProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

       response.body(
                "configs[0].option", equalTo(config),
                "configs[0].value", equalTo(GlobalStaticParameters.configOptionValue)
        );

    }

    @Test
    public void buscarConfigComErro(){
        //Busca dados do usuario
        //fluxo
        configOptionProjetoRequest = new ConfigOptionProjetoRequest(GlobalStaticParameters.config);
        response = configOptionProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "configs[0].option", equalTo(null)
        );

    }

}
