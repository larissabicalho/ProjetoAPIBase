package com.javarestassuredtemplate.utils;
import com.github.javafaker.Faker;

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

    public static String nomeProjeto () {
        return "Projeto Teste Larissa" + " " + GerarDados.numeroAleatorio() + GerarDados.numeroAleatorio();

    }
    public static String numeroAleatorio(){
        return String.valueOf(new Random().nextInt(100));

    }

    public static String dataVersion(){
        long a =  new Date().getTime();
        a = a+86400000;
        String data = new SimpleDateFormat("yyyy-mm-dd").format(a) ;
        return data;
    }

}