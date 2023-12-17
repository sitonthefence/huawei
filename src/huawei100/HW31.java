package huawei100;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HW31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int count=0;
            Pattern compile = Pattern.compile("[^a-z]");
            for (int i = 0; i < split.length; i++) {
                if (!compile.matcher(split[i]).find()){
                    StringBuilder stringBuilder = new StringBuilder(split[i]);
                    String letter = stringBuilder.reverse().toString();
                    for (int j = 0; j < letter.length()-3; j++) {
                        if(letter.substring(j,j+4).matches("[^aeiou][aeiou][^aeiou]e")){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
