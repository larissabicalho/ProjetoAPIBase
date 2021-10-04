package com.javarestassuredtemplate.utils;
import com.github.javafaker.Faker;
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

}