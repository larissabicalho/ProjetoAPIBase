package com.javarestassuredtemplate.tests.Lang;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.enums.Names;
import com.javarestassuredtemplate.requests.Lang.LangOptionProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class BuscarLangOptionTests extends TestBase {

    LangOptionProjetoRequest langOptionProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;


    @Test
    public void buscarLangConfigComSucesso() {
        //Busca dados do usuario
        //fluxo
        String config = GlobalStaticParameters.langOption;
        langOptionProjetoRequest = new LangOptionProjetoRequest(config);
        response = langOptionProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);
          response.body(
                "strings[0].name", equalTo(config),
                "strings[0].localized", equalTo(Names.valueOf(config).getValor()));
    }
}