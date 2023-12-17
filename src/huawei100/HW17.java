package huawei100;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HW17 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int total=0;
            for (int i = 0; i < split.length; i++) {
                total=Integer.valueOf(split[i])+total;
            }
            int [] result=new int[split.length];
            int minNumber = getMinNumber(total);
            for (int i = 1; i <=minNumber; i++) {
                if (String.valueOf(i).contains("7") || (i % 7 == 0)){
                    result[i%result.length-1]++;
                }
            }
            for (int i = 0; i <result.length ; i++) {
                System.out.print(result[i]+" ");
            }
        }
    }
    public  static int getMinNumber(int total) {
        int count = 0;
        for (int i = 1; i <= 200; i++) {
            if (String.valueOf(i).contains("7") || (i % 7 == 0)) {
                count++;
                if (count >=total) {
                    return i;
                }
            }
        }
        return -1;
    }
}
