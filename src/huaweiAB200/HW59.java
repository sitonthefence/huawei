package huaweiAB200;

import java.util.Scanner;

public class HW59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int [] values=new int[length];
            for (int i = 0; i < length; i++) {
                values[i]=in.nextInt();
            }
            int W=1474560/512;
            int[] weight=new int[length];
            for (int i = 0; i < length; i++) {
                    weight[i]=(int)Math.ceil((double) values[i]/512);
            }
            int[][] dp=new int[length][1+W];
            for (int j = weight[0]; j < 1+W; j++) {
                dp[0][j]=values[0];
            }
            for (int i = 1; i <length ; i++) {
                for (int j = 1; j <1+W ; j++) {
                   if(j<weight[i]){
                       dp[i][j]=dp[i-1][j];
                   }
                   else {
                       dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                   }
                }
            }
            System.out.println(dp[length-1][W]);

        }
    }
}
