    package com.javarestassuredtemplate.tests.Projects;

    import com.javarestassuredtemplate.bases.TestBase;
    import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
    import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
    import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjeto;
    import com.javarestassuredtemplate.requests.Project.CriarProjetoRequest;
    import io.restassured.response.ValidatableResponse;
    import org.apache.http.HttpStatus;
    import org.testng.annotations.Test;

    import static org.hamcrest.Matchers.equalTo;

    public class CriarProjetoTest extends TestBase {

        CriarProjetoRequest criarProjetoRequest;
        ValidatableResponse response;
        int statusCodeEsperado = HttpStatus.SC_CREATED;
        @Test
        public void criarProjetoSucesso() {
            CriarProjeto criarProjeto = new CriarProjeto();

            criarProjeto.setDados();

            criarProjetoRequest = new CriarProjetoRequest();

            criarProjetoRequest.setJsonBodyUsingJavaObject(criarProjeto);

            response = criarProjetoRequest.executeRequest();

            //Validações
            response.log().all();
            response.statusCode(statusCodeEsperado);

            response.body("project.name", equalTo(criarProjeto.getName()),
                    "project.status.id", equalTo((int)criarProjeto.getStatus().getId()),
                            "project.status.name",equalTo(criarProjeto.getStatus().getName()),
                                    "project.status.label",equalTo(criarProjeto.getStatus().getLabel()),
                                        "project.description", equalTo(criarProjeto.getDescription()),
                                         "project.enabled", equalTo(criarProjeto.isEnabled()),
                                            "project.view_state.id", equalTo((int)criarProjeto.getView_state().getId()),
                                                    "project.view_state.name",equalTo(criarProjeto.getView_state().getName()),
                                                            "project.view_state.label",equalTo(criarProjeto.getView_state().getLabel()));

               String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
               BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        }

        @Test
        public void criarProjetoSucessoJavascript() {
            CriarProjeto criarProjeto = new CriarProjeto();

            criarProjeto.setDadosJavaScript();

            criarProjetoRequest = new CriarProjetoRequest();

            criarProjetoRequest.setJsonBodyUsingJavaObject(criarProjeto);

            response = criarProjetoRequest.executeRequest();

            //Validações
            response.log().all();
            response.statusCode(statusCodeEsperado);

            response.body("project.name", equalTo(criarProjeto.getName()),
                    "project.status.id", equalTo((int)criarProjeto.getStatus().getId()),
                    "project.status.name",equalTo(criarProjeto.getStatus().getName()),
                    "project.status.label",equalTo(criarProjeto.getStatus().getLabel()),
                    "project.description", equalTo(criarProjeto.getDescription()),
                    "project.enabled", equalTo(criarProjeto.isEnabled()),
                    "project.view_state.id", equalTo((int)criarProjeto.getView_state().getId()),
                    "project.view_state.name",equalTo(criarProjeto.getView_state().getName()),
                    "project.view_state.label",equalTo(criarProjeto.getView_state().getLabel()));

            String idProjeto = BuscarProjetoDBSteps.retornaIdProjeto();
            BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        }

    }
