package com.javarestassuredtemplate.utils;

import org.apache.commons.codec.binary.Base64;
import org.mariadb.jdbc.MariaDbBlob;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

public class GeneralUtils {
    public static String readFileToAString(String path){
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded, StandardCharsets.ISO_8859_1);
    }




    public static String getNowDate(String mask){
        DateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getMethodNameByLevel(int level){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        return stackTrace[level].getMethodName();
    }

    public static String getAllStackTrace(ITestResult result){
        String allStackTrace = "";

        for(StackTraceElement stackTrace : result.getThrowable().getStackTrace()){
            allStackTrace = allStackTrace + "<br>" + stackTrace.toString();
        }

        return allStackTrace;
    }

    public static String convertObjectToJsonString(Object object){
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String formatJson(final String json) {
        final int indent_width = 4;
        final char[] chars = json.toCharArray();
        final String newline = System.lineSeparator();

        String ret = "";
        boolean begin_quotes = false;

        for (int i = 0, indent = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '\"') {
                ret += c;
                begin_quotes = !begin_quotes;
                continue;
            }

            if (!begin_quotes) {
                switch (c) {
                    case '{':
                    case '[':
                        ret += c + newline + String.format("%" + (indent += indent_width) + "s", "");
                        continue;
                    case '}':
                    case ']':
                        ret += newline + ((indent -= indent_width) > 0 ? String.format("%" + indent + "s", "") : "") + c;
                        continue;
                    case ':':
                        ret += c + " ";
                        continue;
                    case ',':
                        ret += c + newline + (indent > 0 ? String.format("%" + indent + "s", "") : "");
                        continue;
                    default:
                        if (Character.isWhitespace(c)) continue;
                }
            }

            ret += c + (c == '\\' ? "" + chars[++i] : "");
        }

        return ret;
    }

    public static Blob stringToClob(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                return new SerialBlob(str.getBytes());
            } catch (SQLException var2) {
               var2.getMessage();
            }
        }
        return null;
    }

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
}
