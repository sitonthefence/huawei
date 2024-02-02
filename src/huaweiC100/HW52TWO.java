package huaweiC100;

import java.util.Scanner;

public class HW52TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long n = in.nextLong();
        long m = in.nextLong();
        long answer=0;
        while (k!=0){
            if(k%m==n){
                answer++;
            }
            k/=m;
        }
        System.out.println(answer);
    }
}
