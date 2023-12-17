package huawei100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HW15 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            for (int i = 0; i < split.length-1; i++) {
                for (int j = i+1; j <split.length ; j++) {
                    if(Integer.valueOf(split[i]+split[j])<Integer.valueOf(split[j]+split[i])){
                        String s=split[j];
                        split[j]=split[i];
                        split[i]=s;
                    }
                }
            }
            for (String s : split) {
                System.out.print(s);
            }



        }
    }
}
