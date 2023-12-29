package huaweiAB100;

import java.util.Scanner;

public class HW92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.next();
            int k = in.nextInt();
            String[] split = s.split(",");
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < split.length-k+1; i++) {
                int total=0;
                for (int j = i; j < i+k; j++) {
                  total=Integer.valueOf(split[j])+total;
                }
                max=Math.max(max,total);
            }
            System.out.println(max);
        }
    }
}
