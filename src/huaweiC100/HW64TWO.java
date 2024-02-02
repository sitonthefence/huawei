package huaweiC100;

import java.util.Scanner;

public class HW64TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int perWeightA = in.nextInt();
        int perWeightB = in.nextInt();
        int maxWeight=in.nextInt();
        int profitA=in.nextInt();
        int profitB = in.nextInt();
        int maxProfit=Integer.MIN_VALUE;
        for (int i = 1; i <=(maxWeight-perWeightB)/perWeightA ; i++) {
           int remain=maxWeight-perWeightA*i;
           if(remain%perWeightB==0){
               maxProfit=Math.max(maxProfit,i*profitA+(remain/perWeightB)*profitB);
           }
        }
        System.out.println(maxProfit);
    }
}
