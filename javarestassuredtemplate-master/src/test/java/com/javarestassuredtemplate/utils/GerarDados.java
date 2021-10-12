package com.javarestassuredtemplate.utils;
import com.github.javafaker.Faker;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
public class GerarDados {
    private static final Locale LOCALE = new Locale("pt-BR");

    public static String nomeUser(){
        Faker faker = new Faker(LOCALE);
        return faker.name().firstName();
    }
    public static String fullName(){
        Faker faker = new Faker(LOCALE);
        return faker.name().firstName() +" "+ faker.name().lastName();
    }
    public static String email(){
        Faker faker = new Faker(LOCALE);
        return faker.internet().emailAddress();
    }


    public static String numeroAleatorio(){
        return String.valueOf(new Random().nextInt(100));

    }

    public static String nomeProjeto () {
        return "Projeto Teste Larissa" + " " + GerarDados.numeroAleatorio() + GerarDados.numeroAleatorio();

    }

    public static String dataVersion(){
        long a =  new Date().getTime();
        a = a+86400000;
        String data = new SimpleDateFormat("yyyy-mm-dd").format(a) ;
        return data;
    }


    public static String getRandomString(int i)
    {

        byte[] bytearray;
        String mystring;
        StringBuffer thebuffer;

        bytearray = new byte[256];
        new Random().nextBytes(bytearray);

        mystring
                = new String(bytearray, Charset.forName("UTF-8"));

        // Create the StringBuffer
        thebuffer = new StringBuffer();

        for (int m = 0; m < mystring.length(); m++) {

            char n = mystring.charAt(m);

            if (((n >= 'A' && n <= 'Z')
                    || (n >= '0' && n <= '9'))
                    && (i > 0)) {

                thebuffer.append(n);
                i--;
            }
        }

        // resulting string
        return thebuffer.toString();
    }



    public static String sumarioIssue() {
        return "Sumario Larissa" + " " + GerarDados.getRandomString(10);

    }

    public static String filename() {
        return "mantis"+GerarDados.numeroAleatorio()+".txt";

    }

    public static String contentFile() {
        return "mantis"+GerarDados.getRandomString(20);

    }

    public static String descricaoNote() {
        return "Descricao Larissa" + " " + GerarDados.getRandomString(10);

    }

    public static String gerarData() {

        int i = (int) new Date().getTime();
        return String.valueOf(i);
    }

}