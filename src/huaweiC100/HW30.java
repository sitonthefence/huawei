package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split("\\,");
            Arrays.sort(split,(o1, o2) -> {
                if(o1.substring(0,2).equals(o2.substring(0,2))){
                    return o1.substring(2).compareTo(o2.substring(2));
                }else {
                    return o1.substring(0,2).compareTo(o2.substring(0,2));
                }
                    }
                    );
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                stringBuilder.append(split[i]+",");
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }
}
