package huaweiC200;

import java.util.Scanner;

public class HW6TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int goodLength = in.nextInt();
            int[] arr = new int[goodLength+1];
            int sum = 0;
            for (int i = 1; i < goodLength+1; i++) {
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            if (sum % 2 == 1) {
                System.out.println(-1);
                continue;
            }
            int bag=sum/2;
            int[][] dp=new int[goodLength+1][bag+1];
            for (int i =1 ; i <=bag ; i++) {
                dp[0][i]=goodLength;
            }
            for (int i = 1; i <goodLength+1 ; i++) {
                for (int j = 1; j < bag+1; j++) {
                    if(j<arr[i]){
                        dp[i][j]=dp[i-1][j];

                    }else {
                        dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-arr[i]]+1);
                    }

                }
            }
            if(dp[goodLength][bag]==goodLength){
                System.out.println(-1);
            }else {
                System.out.println(dp[goodLength][bag]);
            }
    }


}
}