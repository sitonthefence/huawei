package huaweiC200;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW5 {
    static String[] ceil;
    static Pattern p=Pattern.compile("<.*?>");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        ceil= source.split(",");
        for (int i = 0; i < ceil.length; i++) {
          if(!replaceCeil(i)){
              System.out.println(-1);
              return;
          }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < ceil.length; i++) {
            stringBuilder.append(ceil[i]+",");
        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(substring);
    }
    public static boolean replaceCeil(int index){
        String str = ceil[index];
        Matcher m = p.matcher(str);
        while (m.find()){
            String group = m.group();
            if(group.length()!=3){
                return false;
            }
            char reference = group.charAt(1);
            char self = (char) ('A' + index);
            if(reference>'Z'||reference<'A'||reference==self){
                return false;
            }
            if(reference-'A'>=ceil.length){
                return false;
            }
            //注意
            ceil[index] = ceil[index].replaceAll(group, ceil[reference-'A']);
            //最关键
            m=p.matcher( ceil[index]);
        }
        return true;
    }
}
