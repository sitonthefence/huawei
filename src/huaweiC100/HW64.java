package huaweiC100;

import java.util.Scanner;

public class HW64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int perWeightA = in.nextInt();
        int perWeightB = in.nextInt();
        int maxWeight=in.nextInt();
        int profitA=in.nextInt();
        int profitB = in.nextInt();
        int aMax=maxWeight/perWeightA;
        int bMax=maxWeight/perWeightB;
        int maxProfit=Integer.MIN_VALUE;
        for (int i = 1; i < aMax; i++) {
            for (int j = 1; j < bMax; j++) {
                if(perWeightA*i+perWeightB*j<=maxWeight){
                    maxProfit=Math.max(maxProfit,profitA*i+profitB*j);
                }

            }
        }
        System.out.println(maxProfit);



    }
}
