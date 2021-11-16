package com.javarestassuredtemplate.tests.Projects;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarProjetoDBSteps;
import com.javarestassuredtemplate.jsonObjects.Projects.CriarProjetoDataDriven;
import com.javarestassuredtemplate.requests.Projects.CriarProjetoRequest;
import io.restassured.response.ValidatableResponse;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class CriarProjetoDataDrivenTests extends TestBase {

    CriarProjetoRequest criarProjetoRequest;
    ValidatableResponse response;

    @DataProvider
    public Object[][] ProvideData() throws Exception {
        //open excel file
        Workbook workbook = Workbook.getWorkbook(new File("src/test/java/com/javarestassuredtemplate/utils/projeto2.xls"));
        //the required sheet
        Sheet sheet = workbook.getSheet("Projeto");
        //return number of rows(records)
        int records = sheet.getRows() - 1;
        int currentPosition = 1;
        Object[][] values = new Object[records][9];
        for (int i = 0; i < records; i++, currentPosition++) {
            //loop over the rows
            for (int j = 0; j < 9; j++) {
                if (sheet.getRow(j) != null) {
                    values[i][j] = sheet.getCell(j, currentPosition).getContents();
                }
            }

        }
        workbook.close();
        return values;
    }


    @Test(dataProvider = "ProvideData")
    public void CriarProjetoDataDrivenUser(String name, String statusId, String statusName, String description, String enabled, String file_path, String statusIdView, String statusNameView, String StatusCode) {
        CriarProjetoDataDriven criarProjetoDataDriven = new CriarProjetoDataDriven(name, Long.valueOf(statusId), statusName, description, Boolean.valueOf(enabled), file_path, Long.valueOf(statusIdView), statusNameView);
        criarProjetoRequest = new CriarProjetoRequest();
        criarProjetoRequest.setJsonBodyUsingJavaObject(criarProjetoDataDriven);
        response = criarProjetoRequest.executeRequest();
        int statusEsperado = Integer.parseInt(StatusCode);
        //Validações
        response.log().all();
        response.statusCode(statusEsperado);
        BuscarProjetoDBSteps.deletarProjetoDD();

    }
}