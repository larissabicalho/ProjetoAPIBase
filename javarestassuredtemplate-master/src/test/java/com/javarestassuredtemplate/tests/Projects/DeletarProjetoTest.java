package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.requests.Project.DeletarProjetoRequest;
import com.javarestassuredtemplate.requests.Users.DeletarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class DeletarProjetoTest extends TestBase {

    DeletarProjetoRequest deletarProjetoRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void deletarProjetoComSucesso(){
        //Busca dados do usuario
        //fluxo
        String projetoName = GlobalStaticParameters.projetoName;
        String file_path = GlobalStaticParameters.file_path;
        String description = GlobalStaticParameters.description;
        BuscarProjetoDBSteps.insereProjeto(projetoName, file_path, description);
        String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
        deletarProjetoRequest = new DeletarProjetoRequest(idProjeto);
        response = deletarProjetoRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

      /*  response.body(
                "user.name", equalTo(criarUsuario.getUsername()),
                "user.real_name", equalTo(criarUsuario.getReal_name()),
                "user.email", equalTo(criarUsuario.getEmail())
        ); */

    }
}
