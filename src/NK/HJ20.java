package NK;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ20 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            if(s.length()<=8){
                System.out.println("NG");
                continue;
            }
            int count=0;
            Pattern compile1 = Pattern.compile("[a-z]");
            Matcher matcher1 = compile1.matcher(s);
            if(matcher1.find()){
                count++;
            }
            Pattern compile2 = Pattern.compile("[A-Z]");
            Matcher matcher2 = compile2.matcher(s);
            if(matcher2.find()){
                count++;
            }
            Pattern compile3 = Pattern.compile("[0-9]");
            Matcher matcher3 = compile3.matcher(s);
            if(matcher3.find()){
                count++;
            }
            Pattern compile4 = Pattern.compile("\\W");
            Matcher matcher4 = compile4.matcher(s);
            if(matcher4.find()){
                count++;
            }
            if(count<3){
                System.out.println("NG");
                continue;
            }
            String flag="OK";
            for (int i = 0; i < s.length()-5; i++) {
                for (int j =i+3; j <  s.length()-2; j++) {
                      if(s.substring(i,i+3).equals(s.substring(j,j+3))){
                        flag="NG";
                       i=s.length()-5;
                       break;
                      }

                }
                }
            System.out.println(flag);
            }
    }

}
