package com.javarestassuredtemplate.tests.Config;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.enums.Options;
import com.javarestassuredtemplate.requests.Config.ConfigOptionsProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class BuscarConfigsOptionTests extends TestBase {

    ConfigOptionsProjetoRequest configOptionsProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;

    @Test
    public void buscarConfigsComSucesso() {
        //Busca dados do usuario
        //fluxo
        String configs = GlobalStaticParameters.configsOptions;
        configOptionsProjetoRequest = new ConfigOptionsProjetoRequest(configs);
        response = configOptionsProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
        List<Options> list = Arrays.asList(Options.values());
        for (int i = 0; i < list.size() - 2; i++) {

            response.body(
                    "configs.option[" + i + "]", equalTo(list.get(i).name())
            );
        }
    }

}
