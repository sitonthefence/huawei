package huaweiC100;

import java.util.Scanner;

public class HW40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int a=-1;
            int b=-1;
            for (int i = 2; i <=Math.sqrt(source) ; i++) {
                if(isPrime(i)&&source%i==0&&isPrime(source/i)) {
                    a=i;
                    b=source/i;
                    break;

                }
            }
            System.out.println(a+" "+b);

        }
    }
    public static boolean isPrime(int num){
        if(num==1){
            return false;
        }

        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
