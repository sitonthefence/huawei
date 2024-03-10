package LC;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LC224 {
    public static void main(String[] args) {
        System.out.println(calculate("1+1"));
    }
    public static int calculate(String s)  {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        Integer temp=null;
        try {
            temp=(Integer)nashorn.eval(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;

    }
}
