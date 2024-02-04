package huaweiC200;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW5TWO {
    public  static  String[] ceil;
    public static Pattern p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        ceil = text.split(",");
          p = Pattern.compile("<.*?>");
        for (int i = 0; i < ceil.length; i++) {
            if(!replaceCeil(i)){
                System.out.println(-1);
                return;
            }
        }
        StringJoiner result=new StringJoiner(",");
        for (int i = 0; i < ceil.length; i++) {
            result.add(ceil[i]);
        }
        System.out.println(result);
    }
    public static boolean replaceCeil(int index){
        String str = ceil[index];
        Matcher m = p.matcher(str);
        while (m.find()){
            String group = m.group();
            if(group.length()!=3){
                return false;
            }
            char referCharIndex = group.charAt(1);
            int referNumIndex=referCharIndex-'A';
            if(referCharIndex<'A'||referCharIndex>'Z'||referNumIndex==index||referNumIndex>=ceil.length){
                return false;
            }
            ceil[index]=ceil[index].replace(group,ceil[referNumIndex]);
           m=p.matcher(ceil[index]);
        }
        return true;
    }
}
