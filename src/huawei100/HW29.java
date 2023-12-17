package huawei100;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW29 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String target = in.next();
            Pattern compile = Pattern.compile(target);
            Matcher matcher = compile.matcher(source);
            if(matcher.find()){
                System.out.println(matcher.start()+1);
            }


        }
    }
}
