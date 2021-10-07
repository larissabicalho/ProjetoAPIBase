package com.javarestassuredtemplate.tests.Lang;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.enums.Names;
import com.javarestassuredtemplate.requests.Lang.LangOptionProjetoRequest;
import com.javarestassuredtemplate.requests.Lang.LangOptionsProjetoRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class BuscarLangOptionsTests extends TestBase {

    LangOptionsProjetoRequest langOptionsProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_OK;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void buscarLangConfigsComSucesso(){
        //Busca dados do usuario
        //fluxo
        String config = GlobalStaticParameters.langsOptions;
        langOptionsProjetoRequest = new LangOptionsProjetoRequest(config);
        response = langOptionsProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        List<Names> list = Arrays.asList(Names.values());
        for (int i = 0; i < list.size()-1; i++) {
            response.body(
                    "strings.name[" + i + "]", equalTo(list.get(i).name()),
                    "strings.localized[" + i + "]", equalTo(Names.valueOf(list.get(i).name()).getValor())
            );
        }

    }

}
