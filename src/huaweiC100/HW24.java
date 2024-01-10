package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int productNum = in.nextInt();
            int moneyMax = in.nextInt();
            int riskMax = in.nextInt();
            int[] profit=new int[productNum];
            for (int i = 0; i <profit.length ; i++) {
                profit[i]=in.nextInt();
            }
            int[] risk=new int[productNum];
            for (int i = 0; i < risk.length; i++) {
                risk[i]=in.nextInt();
            }
            int[] maxPurchase=new int[productNum];
            for (int i = 0; i < maxPurchase.length; i++) {
                maxPurchase[i]=in.nextInt();
            }
            int [] result=new int[productNum];
            int maxProfit=Integer.MIN_VALUE;
            for (int i = 0; i < productNum-1; i++) {
                for (int j = i+1; j <productNum ; j++) {
                    if(risk[i]+risk[j]>riskMax){
                        continue;
                    }
                    for (int k = 0; k <=maxPurchase[i]  ; k++) {
                        for (int l = 0; l <=maxPurchase[j] ; l++) {
                            if(k+l<=moneyMax){
                                if(profit[i]*k+profit[j]*l>maxProfit){
                                    Arrays.fill(result,0);
                                    result[i]=k;
                                    result[j]=l;
                                }
                            }
                        }
                    }
                }
            }
            for (int i : result) {
                System.out.print(i+" ");
            }






        }
    }
}
