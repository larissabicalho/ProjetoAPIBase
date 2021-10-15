package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import java.util.ArrayList;

public class BuscarIssueDBSteps {
    private static String queriesPath ="src/test/java/com/javarestassuredtemplate/queries/Issues/";



    public static void deletarIssue(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "deletarIssue.sql");
        DBUtils.getQueryResult(queryResultado);
    }

    public static void insereIssue(String projectId, String idTexto){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssue.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary",GerarDados.sumarioIssue());
        query = query.replace("$date_submitted", GerarDados.gerarData());
        query = query.replace("$last_updated", GerarDados.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static void insereIssueHandlerId(String projectId, String idTexto){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssueHandler.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary",GerarDados.sumarioIssue());
        query = query.replace("$date_submitted", GerarDados.gerarData());
        query = query.replace("$last_updated", GerarDados.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaDadosIssue(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosIssue.sql");
        return DBUtils.getQueryResult(queryResultado);
    }


    public static void insereTexto(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirTextoIssue.sql");
        query = query.replace("$description", GlobalStaticParameters.description);
        DBUtils.getQueryResult(query);
    }

    public static void deletarTexto(){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarTexto.sql");
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaDadosTexto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTexto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaIdsTexto(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodosTexto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaIdsIssue(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarIdTodasIssue.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosTodasIssue(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssue.sql");
        return DBUtils.getQueryResult(queryResultado);
    }


    public static ArrayList<String> retornaDadosTodasIssueIdProjeto(String idProjeto){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssueIdProjeto.sql");
        queryResultado = queryResultado.replace("$project_id", idProjeto);
        return DBUtils.getQueryResult(queryResultado);
    }

    public static void deletarIssueId(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarIssueTodas.sql");
        query = query.replace("$idIssue", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void deletarTextoId(String idTexto){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarTextoTodos.sql");
        query = query.replace("$idTexto", idTexto);
        DBUtils.getQueryResult(query);
    }

    public static void inserirCustom_Field(String name){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirCustomField.sql");
        query = query.replace("$name", name);
        DBUtils.getQueryResult(query);
    }

    public static String  retornarCustom_FieldId(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarCustomField.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarCustom_Field(){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarCustomField.sql");
        DBUtils.getQueryResult(query);
    }

    public static String retornarIdBugNote(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarIdNote.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarNote(String idNote){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarBugNote.sql");
        query = query.replace("$idNote", idNote);
        DBUtils.getQueryResult(query);
    }

    public static String retornarIdBugNoteText(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarIdNoteText.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarNoteText(String idNoteText){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarBugNoteText.sql");
        query = query.replace("$idNoteText", idNoteText);
        DBUtils.getQueryResult(query);
    }

    public static String retornarIdAttachment(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarIdAttachment.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarAttachment(String idAttachment){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarAttachmentIssue.sql");
        query = query.replace("$idAttachment", idAttachment);
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaDadosTodasIssuesUnassigned(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssuesUnassigned.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosTodasIssuesReported(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssuesReported.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosTodasIssuesAssigned(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssuesAssigned.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosTodasIssuesMonitored(){
        String queryResultado = GeneralUtils.readFileToAString(queriesPath + "retornarDadosTodasIssuesMonitored.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static void inserirBugNoteText(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssueNoteText.sql");
        query = query.replace("$note", GerarDados.descricaoNote());
        DBUtils.getQueryResult(query);
    }

    public static void inserirBugNote(String idBug, String idText){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssueNote.sql");
        query = query.replace("$bug_id", idBug);
        query = query.replace("$bugnote_text_id", idText);
        DBUtils.getQueryResult(query);
    }

    public static void inserirMonitoramento(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirMonitoramentoAdm.sql");
        query = query.replace("$bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void deletarMonitoramento(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarMonitored.sql");
        query = query.replace("$bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornarIssueMonitor(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarDadosIssuesMonitor.sql");
        query = query.replace("$bug_id", idIssue);
       return  DBUtils.getQueryResult(query);
    }

    public static void insereTag(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirTags.sql");
        query = query.replace("$name", GerarDados.tagName());
        query = query.replace("$description", GerarDados.descricaoNote());
        query = query.replace("$date_created", GerarDados.gerarData());
        query = query.replace("$date_updated", GerarDados.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornarTags(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarTags.sql");
        return  DBUtils.getQueryResult(query);
    }

    public static void deletarTags(){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletarTags.sql");
         DBUtils.getQueryResult(query);
    }

    public static void deletarRelationship(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "deletaRelationships.sql");
        query = query.replace("$source_bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void inserirRelationship(String idIssue, String idIssue2){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirRelationships.sql");
        query = query.replace("$source_bug_id", idIssue);
        query = query.replace("$destination_bug_id", idIssue2);
        DBUtils.getQueryResult(query);
    }

    public static String retornarRelationship(String idIssue){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarRelationships.sql");
        query = query.replace("$source_bug_id", idIssue);
       return DBUtils.getQueryResult(query).get(0);
    }

    public static void insereFilterUrgente(){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirFilterUrgente.sql");
        query = query.replace("$name", GerarDados.filterName());
        query = query.replace("$filter_string", GerarDados.filter_StringUrgente());
        DBUtils.getQueryResult(query);
    }

    public static void insereIssueUrgente(String projectId, String idTexto){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssueUrgente.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary",GerarDados.sumarioIssue());
        query = query.replace("$date_submitted", GerarDados.gerarData());
        query = query.replace("$last_updated", GerarDados.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static void insereIssueUrgente2(String projectId, String idTexto){
        String query = GeneralUtils.readFileToAString(queriesPath + "inserirIssueUrgente.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary",GerarDados.sumarioIssue());
        query = query.replace("$date_submitted", GerarDados.gerarData2());
        query = query.replace("$last_updated", GerarDados.gerarData2());
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornarIssueFilter(){
        String query = GeneralUtils.readFileToAString(queriesPath + "retornarDadosIssueFilter.sql");
        return  DBUtils.getQueryResult(query);
    }


}
