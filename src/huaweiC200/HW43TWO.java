package huaweiC200;

import java.util.Scanner;

public class HW43TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m=n+1;
        while (Integer.bitCount(m)!=Integer.bitCount(n)){
            m++;
        }
        System.out.println(m);


    }
}
