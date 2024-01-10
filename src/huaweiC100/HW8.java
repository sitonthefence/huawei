package huaweiC100;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int count=0;
            for (int i = 0; i <= source; i++) {
                String str = String.valueOf(i);
                Pattern compile = Pattern.compile("4");
                Matcher matcher = compile.matcher(str);
                if(matcher.find()) {
                    count++;
                }
            }
            System.out.println(source-count);


        }
    }
}
