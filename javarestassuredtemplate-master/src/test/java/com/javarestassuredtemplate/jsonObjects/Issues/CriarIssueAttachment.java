package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.GlobalParameters;
import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GerarDados;

import com.sun.xml.bind.v2.runtime.output.Encoded;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.SerializationUtils;
import org.mariadb.jdbc.MariaDbBlob;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarIssueAttachment {
    private String summary = GerarDados.sumarioIssue();
    private String description = GlobalStaticParameters.description;
    private Category category;
    private Project project;
    private Custom_Field custom_field;
    private Files[] files;

    public static String encodeFileToBase64Binary(String fileName) {
        File file = new File("src/test/java/com/javarestassuredtemplate/utils/" + fileName);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedfile;
    }



    public void setDados(String projectName, long idProjeto, long idField) throws IOException, SQLException {
        category = new Category(GlobalStaticParameters.idCategory, GlobalStaticParameters.nameCategory);
        project = new Project(idProjeto, projectName);
        custom_field = new Custom_Field();
        Field field = new Field();
        field.setId(idField);
        field.setName(GlobalStaticParameters.nameField);
        custom_field.setField(field);
        custom_field.setValue(GlobalStaticParameters.valueCustomField);
        Files file1 = new Files();
        file1.setName(GerarDados.filename());
        file1.setContent(encodeFileToBase64Binary("file.png"));
        files = new Files[]{file1};
    }
}


