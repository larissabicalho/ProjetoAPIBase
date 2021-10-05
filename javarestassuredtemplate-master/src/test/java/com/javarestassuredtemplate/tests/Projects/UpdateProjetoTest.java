    package com.javarestassuredtemplate.tests.Projects;

    import com.javarestassuredtemplate.bases.TestBase;
    import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
    import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
    import com.javarestassuredtemplate.jsonObjects.Projects.UpdateProjeto;
    import com.javarestassuredtemplate.requests.Project.BuscarProjetoRequest;
    import com.javarestassuredtemplate.requests.Project.CriarProjetoRequest;
    import com.javarestassuredtemplate.requests.Project.UpdateProjetoRequest;
    import io.restassured.response.ValidatableResponse;
    import org.apache.http.HttpStatus;
    import org.testng.annotations.Test;

    import static org.hamcrest.Matchers.containsString;
    import static org.hamcrest.Matchers.equalTo;

    public class UpdateProjetoTest extends TestBase {

        CriarProjetoRequest criarProjetoRequest;
        ValidatableResponse response;
        int statusCodeEsperado = HttpStatus.SC_OK;
        @Test
        public void updateProjetoSucesso() {
            BuscarProjetoDBSteps.insereProjeto();
            String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
            UpdateProjeto updateProjeto = new UpdateProjeto();
            UpdateProjetoRequest updateProjetoRequest = new UpdateProjetoRequest(idProjeto);
            response = updateProjetoRequest.executeRequest();
            updateProjeto.setId(Long.parseLong(idProjeto));

            updateProjetoRequest.setJsonBodyUsingJavaObject(updateProjeto);

            response = updateProjetoRequest.executeRequest();

            //Validações
            response.log().all();
            response.statusCode(statusCodeEsperado);
            response.statusLine(containsString(" Project with id "+idProjeto+" "+"Updated"));

            BuscarProjetoDBSteps.deletarProjeto(idProjeto);

        }
    }
