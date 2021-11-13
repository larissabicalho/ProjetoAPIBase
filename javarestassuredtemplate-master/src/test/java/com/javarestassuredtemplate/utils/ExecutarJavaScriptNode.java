package com.javarestassuredtemplate.utils;

import javax.script.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExecutarJavaScriptNode {

    public ExecutarJavaScriptNode() throws ScriptException {
    }

     public static String executaJavaScript() {

         ScriptEngineManager factory = new ScriptEngineManager();
         ScriptEngine engine = factory.getEngineByName("JavaScript");

         try {
             FileReader reader = new FileReader("src/test/java/com/javarestassuredtemplate/utils/example.js");
               engine.put("length", 10);
             /*  engine.eval( "function makeid(length) {\n" +
                       "    var result           = '';\n" +
                       "    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';\n" +
                       "    var charactersLength = characters.length;\n" +
                       "    for ( var i = 0; i < length; i++ ) {\n" +
                       "      result += characters.charAt(Math.floor(Math.random() * \n" +
                       " charactersLength));\n" +
                       "   }\n" +
                       "   return result;\n" +
                       "}\n" );*/
             engine.eval(reader);
            engine.eval("var s= makeid(length)" );

              String aleatorio = String.valueOf(engine.get("s"));

              return aleatorio;


         } catch (ScriptException | FileNotFoundException e) {
             e.printStackTrace();
         }


        return null;
     }
 /*   Runtime rt = Runtime.getRuntime();
    String[] commands = {"node example.js", "args"};
    Process proc = rt.exec(commands);
    BufferedReader stdInput;

       stdInput = new BufferedReader(new
            InputStreamReader(proc.getInputStream()));

    BufferedReader stdError = new BufferedReader(new
            InputStreamReader(proc.getErrorStream()));
        String line;


        while ((line = stdInput.readLine()) != null) {
            System.out.println(line);
        }
    }
 *
/

}
  */

    /*    ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            FileReader reader = new FileReader("src/test/java/com/javarestassuredtemplate/utils/example.js");
            engine.eval(reader);
            System.out.println("Max num: " + engine.get("x"));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();

        } */


}