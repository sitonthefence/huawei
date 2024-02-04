package huaweiC200;

import java.util.Scanner;

public class HW12TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] values=new int[length];
        for (int i = 0; i < length; i++) {
            values[i]=in.nextInt();
        }
        int W=1474560/512;
        int[] weight=new int[length];
        for (int i = 0; i < length; i++) {
            weight[i]=(int) Math.ceil((double)values[i]/512);
        }
        int[] dp=new int[W+1];
        for (int j =weight[0] ; j <W+1 ; j++) {
            dp[j]=values[0];
        }
        for (int i = 1; i <length ; i++) {
            for (int j=W;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+values[i]);
            }
        }
        System.out.println(dp[W]);

    }
}
