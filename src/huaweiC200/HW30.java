package huaweiC200;

import java.math.BigInteger;
import java.util.Scanner;

public class HW30 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int M = in.nextInt();
            BigInteger[] factor=new BigInteger[M-7+1];
            factor[0]=new BigInteger("1");
            for (int i = 1; i <=M-7 ; i++) {
                factor[i]=factor[i-1].multiply(new BigInteger(i+""));
            }

            int oneCount=M-7;
            int twoCount=0;
            BigInteger answer = new BigInteger("0");
            while (oneCount>=0){
                if((oneCount+twoCount)%2==1){
                    if(oneCount==0||twoCount==0){
                        answer=answer.add(new BigInteger("1"));
                    }else {
                        answer = answer.add(factor[oneCount + twoCount].divide(factor[oneCount].multiply(factor[twoCount])));
                    }

                }
                oneCount-=2;
                twoCount+=1;
            }
            System.out.println(answer);

        }

    }
}
