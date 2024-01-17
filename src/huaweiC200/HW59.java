package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW59 {
     static List<String> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        list=new ArrayList<>();
       while (in.hasNextLine()){
           String source = in.nextLine();
           if("".equals(source)){
               break;
           }else {
               list.add(source);
           }
       }

        
        StringBuilder stringBuilder=new StringBuilder();
        for (String line : list) {
            //注意收集结果
            line=line.replaceAll("\\\\[\"']","")
                    .replaceAll("\".*?\"","a")
                    .replaceAll("'.*?'","a")
                    .replaceAll("-.+","")
                     . replaceAll("\\s+","");
            stringBuilder.append(line);
        }
        stringBuilder.append(";");
        //注意先后顺序
        String s = stringBuilder.toString().replaceAll(";+", ";").replaceAll("^;", "");
        int count=0;
        for (int i = 0; i < s.length(); i++) {
         if(s.charAt(i)==';'){
             count++;
         }

        }
        System.out.println(count);

    }
}
