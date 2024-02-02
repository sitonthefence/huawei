package huaweiC100;

import java.util.Scanner;

public class HW74TWO {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()){
            long n = in.nextLong();
            if(n>2147483647){
                System.out.println("N");
                return;
            }
            long a=-1;
            long b=-1;
            for (int k =2 ; k*k < 2*n; k++) {
                if(2*n%k!=0||(2*n/k+1-k)%2!=0) continue;
                 a=(2*n/k+1-k)/2;
                 b=a+k-1;
                 break;
            }
            if(a==-1){
                System.out.println("N");
                break;
            }


            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(n+"=");

            for (long i =a ; i <=b ; i++) {
                stringBuilder.append(i+"+");
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }

    }
}
