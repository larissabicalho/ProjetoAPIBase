package com.javarestassuredtemplate.utils;

import javax.script.*;
import java.io.*;

public class ExecutarJavaScriptNode {

    public ExecutarJavaScriptNode() {
    }

    public static String executaJavaScript() {

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        try {
            FileReader reader = new FileReader("src/test/java/com/javarestassuredtemplate/utils/example.js");
            engine.put("length", 10);
            engine.eval(reader);
            engine.eval("var s= makeid(length)");

            String aleatorio = String.valueOf(engine.get("s"));

            return aleatorio;


        } catch (ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}