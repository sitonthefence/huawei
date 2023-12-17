package NK;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HJ54 {
    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
            System.out.println(nashorn.eval(source));


        }
    }



}
