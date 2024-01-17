package huaweiC200;


import java.math.BigInteger;
import java.util.Scanner;

public class HW30TWO {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int M = in.nextInt();
            BigInteger[] dpA=new BigInteger[M+2];
            for (int i = 0; i < M+2; i++) {
                dpA[i]=new BigInteger("0");
            }
            dpA[M]=new BigInteger("1");
            BigInteger[] dpB=new BigInteger[M+2];
            for (int i = 0; i < M+2 ; i++) {
                dpB[i]=new BigInteger("0");
            }
            //是add不是and
            for (int i = M-1; i >=7 ; i--) {
                dpB[i]=dpA[i+1].add(dpA[i+2]);
                dpA[i]=dpB[i+1].add(dpB[i+2]);
            }
            System.out.println(dpB[7]);
        }



    }
}
