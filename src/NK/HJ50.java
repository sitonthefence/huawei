package NK;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HJ50 {
    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String replace = source.replace('[', '(').replace(']', ')')
                    .replace('{', '(').replace('}', ')');
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine engineByName = scriptEngineManager.getEngineByName("nashorn");
            System.out.println(engineByName.eval(replace));


        }


    }


}
