package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW24TWO {
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
            int minRisk=Integer.MAX_VALUE;
            int currentProfit=0;
            for (int i = 0; i < productNum; i++) {
                if(risk[i]<=riskMax){
                    int c = Math.min(moneyMax, maxPurchase[i]);
                    currentProfit=c*profit[i];
                    if(currentProfit>maxProfit||(currentProfit==maxProfit&&risk[i]<minRisk)){
                        maxProfit=currentProfit;
                        minRisk=risk[i];
                        Arrays.fill(result,0);
                        result[i]=c;
                    }

                }

            }
            int a=0;
            int b=0;
            int currentRisk=0;
            for (int i = 0; i < productNum-1; i++) {
                for (int j = i+1; j <productNum ; j++) {
                    if(risk[i]+risk[j]>riskMax){
                        continue;
                    }
                    if(profit[i]>profit[j]){
                        a=Math.min(maxPurchase[i],moneyMax);
                        b=Math.min(maxPurchase[j],moneyMax-a);

                    }else if (profit[i]<profit[j]){
                        b=Math.min(maxPurchase[j],moneyMax);
                        a=Math.min(maxPurchase[i],moneyMax-b);

                    }else if(risk[i]<risk[j]){
                        a=Math.min(maxPurchase[i],moneyMax);
                        b=Math.min(maxPurchase[j],moneyMax-a);
                    }else {
                        b=Math.min(maxPurchase[j],moneyMax);
                        a=Math.min(maxPurchase[i],moneyMax-b);
                    }
                currentRisk=risk[i]+risk[j];
                 currentProfit=a*profit[i]+b*profit[j];
                 if(currentProfit>maxProfit||(currentProfit==maxProfit&&currentRisk<minRisk)){
                     minRisk=currentRisk;
                     maxProfit=currentProfit;
                     Arrays.fill(result,0);
                     result[i]=a;
                     result[j]=b;
                 }
                }
            }


            for (int i : result) {
                System.out.print(i+" ");
            }

        }
    }
}
