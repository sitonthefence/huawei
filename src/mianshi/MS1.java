package mianshi;

import java.math.BigInteger;
import java.util.Scanner;

public class MS1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=i;
        }
        for (int i = 2; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
               if(arr[j]%arr[i]==0){
                   arr[j]=arr[j]/arr[i];
               }

            }

        }
        BigInteger target = BigInteger.ONE;
        for (int i = 2; i <=n ; i++) {
          target = target.multiply(new BigInteger(String.valueOf(arr[i])));

        }
        System.out.println(target);


    }
}
