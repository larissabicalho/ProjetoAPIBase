package com.javarestassuredtemplate.tests.Issues;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarIssueDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Issues.MonitorEspecificoUser;
import com.javarestassuredtemplate.requests.Issues.MonitorarIssueRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class MonitorarIssueEspecificoUserTests extends TestBase {

    MonitorarIssueRequest monitorarIssueRequest;
    ValidatableResponse response;
    int statusCodeEsperado = HttpStatus.SC_CREATED;
    GlobalStaticParameters globalStaticParameters;

    @Test
    public void BuscarIssueFilterMonitoredComSucesso() {
        //Busca dados do usuario
        //fluxo

        BuscarUsuarioDBSteps.insereUsuario();
        String idUsuario = BuscarUsuarioDBSteps.retornaUsernameUsuario();

        BuscarProjetoDBSteps.insereProjeto();
        String idProjeto = BuscarProjetoDBSteps.retornaDadosProjeto().get(0);
        BuscarIssueDBSteps.insereTexto();
        String idTexto = BuscarIssueDBSteps.retornaDadosTexto().get(0);
        BuscarIssueDBSteps.insereIssue(idProjeto, idTexto);
        String idIssue = BuscarIssueDBSteps.retornaDadosIssue().get(0);
        MonitorEspecificoUser monitorEspecificoUser = new MonitorEspecificoUser();
        monitorEspecificoUser.setDados(BuscarUsuarioDBSteps.retornaUsuarioMonitor().get(0),BuscarUsuarioDBSteps.retornaUsuarioMonitor().get(1));
        monitorarIssueRequest = new MonitorarIssueRequest(idIssue);
        monitorarIssueRequest.setJsonBodyUsingJavaObject(monitorEspecificoUser);
        response = monitorarIssueRequest.executeRequest();
        //Validações
        response.log().all();
        response.statusCode(statusCodeEsperado);

        response.body(
                "issues.id[0]", equalTo(Integer.valueOf(idIssue)),
                "issues.monitors[0].name[0]", equalTo(BuscarUsuarioDBSteps.retornaUsuarioMonitor().get(0)),
                "issues.monitors[0].real_name[0]",  equalTo(BuscarUsuarioDBSteps.retornaUsuarioMonitor().get(1))
        );

        BuscarIssueDBSteps.deletarMonitoramento(idIssue);
        BuscarProjetoDBSteps.deletarProjeto(idProjeto);
        BuscarIssueDBSteps.deletarIssueId(idIssue);
        BuscarIssueDBSteps.deletarTextoId(idTexto);
        String idUser = BuscarUsuarioDBSteps.retornaIdUsuario();
        BuscarUsuarioDBSteps.deletarUsuarioId(idUser);
    }
}
