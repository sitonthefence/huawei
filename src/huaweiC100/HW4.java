package huaweiC100;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i)=='<'){
                    if(stringBuilder.length()>0){
                       stringBuilder.deleteCharAt(stringBuilder.length()-1);
                    }
                }else {
                    stringBuilder.append(source.charAt(i));
                }

            }
            String str = stringBuilder.toString();
          boolean flag=false;
          if(str.length()>=8){
              Pattern compile1 = Pattern.compile("[A-Z]");
              Matcher matcher1 = compile1.matcher(str);
              Pattern compile2 = Pattern.compile("[a-z]");
              Matcher matcher2 = compile2.matcher(str);
              Pattern compile3 = Pattern.compile("[0-9]");
              Matcher matcher3 = compile3.matcher(str);
              Pattern compile4 = Pattern.compile("[^a-zA-Z0-9\\s]");
              Matcher matcher4 = compile4.matcher(str);
              if(matcher1.find()&&matcher2.find()&&matcher3.find()&&matcher4.find()){
                  flag=true;
              }


          }
            System.out.print(str+",");
            System.out.println(flag);


        }


    }
}
