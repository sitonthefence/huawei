package huaweiC100;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HW13 {
    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int left=-1;
            int right=-1;
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < source.length(); i++) {
                for (int j = i; j <source.length() ; j++) {
                  if((j-i+1)>max&&check(source.substring(i,j+1))){
                      max=j-i+1;
                      left=i;
                      right=j;
                  }
                }
            }
            if(left!=-1){
                String substring = source.substring(left, right + 1);
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
                Object eval = nashorn.eval(substring);
                System.out.println(eval);
            }else {
                System.out.println(0);
            }
        }
    }
    public static boolean check(String str){
       if(str.matches("[0-9]+([*+-][0-9]+)*")){
           return true;
       }
       return false;
    }

}
