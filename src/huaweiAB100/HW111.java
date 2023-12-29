package huaweiAB100;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW111 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String regex = in.next();
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(source);
            if(matcher.find()){
                System.out.println(matcher.start());
            }else {
                System.out.println(-1);
            }
        }

    }



}
