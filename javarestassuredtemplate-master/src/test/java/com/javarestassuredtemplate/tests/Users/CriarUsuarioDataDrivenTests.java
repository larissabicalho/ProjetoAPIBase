package com.javarestassuredtemplate.tests.Users;
import java.io.File;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.BuscarUsuarioDBSteps;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Users.CriarUsuarioDataDriven;
import com.javarestassuredtemplate.requests.Users.CriarUsuarioRequest;
import io.restassured.response.ValidatableResponse;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CriarUsuarioDataDrivenTests extends TestBase {
    CriarUsuarioRequest criarUsuarioRequest;
    ValidatableResponse response;
    GlobalStaticParameters globalStaticParameters;
        @DataProvider
        public Object[][] ProvideData() throws Exception{
            //open excel file
            Workbook workbook = Workbook.getWorkbook(new File("src/test/java/com/javarestassuredtemplate/utils/usuarioDataDriven.xls"));
            //the required sheet
            Sheet sheet = workbook.getSheet("User");
            //return number of rows(records)
            int records = sheet.getRows()-1;
            int currentPosition = 1;
            Object[][] values = new Object[records][5];
            for(int i = 0 ; i < records; i++, currentPosition++) {
                    //loop over the rows
                    for (int j = 0; j < 5; j++) {
                         if(sheet.getRow(j)!=null) {
                             values[i][j] = sheet.getCell(j, currentPosition).getContents();
                         }
                    }

            }
            workbook.close();
            return values;
        }


        @Test(dataProvider="ProvideData")
        public void CriarUsuarioDataDriven(String username, String password, String realname, String email, String StatusCode){
            CriarUsuarioDataDriven criarUsuarioDataDriven =  new CriarUsuarioDataDriven(username,password,realname,email);
            criarUsuarioRequest = new CriarUsuarioRequest();
            criarUsuarioRequest.setJsonBodyUsingJavaObject(criarUsuarioDataDriven);
            response = criarUsuarioRequest.executeRequest();
            int statusEsperado = Integer.parseInt(StatusCode);
            //Validações
            response.log().all();
            response.statusCode(statusEsperado);

            BuscarUsuarioDBSteps.deletarUsuario();

        }

}

