package huaweiC200;

import java.util.Scanner;

public class HW43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int count = Integer.bitCount(n);
            int m=n+1;
            while (Integer.bitCount(m)!=count){
                m++;
            }
            System.out.println(m);

        }
    }
}
