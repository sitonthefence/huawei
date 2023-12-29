package huaweiAB100;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HW32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            Pattern compile = Pattern.compile("[^0-9a-z]");
            if(compile.matcher(source).find()){
                System.out.println("!error");
                continue;
            }


            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(source.charAt(i)>='0'&&source.charAt(i)<='9'){
                   for (int j=0;j<Integer.valueOf(Character.toString(source.charAt(i)));j++){
                       stringBuilder.append(source.charAt(i+1));
                   }
                   i++;
                }else {

                    stringBuilder.append(source.charAt(i));
                }

            }
            System.out.println(stringBuilder);
        }


    }
}
