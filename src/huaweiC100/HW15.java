package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            Arrays.sort(split,(o1, o2)->o1.charAt(o1.length()-1)-o2.charAt(o2.length()-1));
        StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                stringBuilder.append(split[i]+",");
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }
}
