package huaweiAB100;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HW6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            Pattern compile = Pattern.compile("([a-zA-Z])\\1");

            while (compile.matcher(source).find()){
              source = compile.matcher(source).replaceAll("");

            }
            System.out.println(source.length());

        }


    }
}
