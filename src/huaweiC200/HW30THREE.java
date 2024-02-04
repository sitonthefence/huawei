package huaweiC200;

import java.math.BigInteger;
import java.util.Scanner;

public class HW30THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        BigInteger[] A=new BigInteger[M+2];
        for (int i = 0; i < A.length; i++)   A[i]=new BigInteger("0");
        A[M]=new BigInteger("1");
        BigInteger[] B=new BigInteger[M+2];
        for (int i = 0; i <B.length ; i++) B[i]=new BigInteger("0");
        for (int i = M-1; i >=7 ; i--) {
              B[i]=A[i+1].add(A[i+2]);
              A[i]=B[i+1].add(B[i+2]);
        }
        System.out.println(B[7]);

    }
}
