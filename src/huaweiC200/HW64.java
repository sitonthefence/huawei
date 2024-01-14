package huaweiC200;

import java.util.Scanner;

public class HW64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();
            int m=str2.length();
            int n = str1.length();
            int[][] dp=new int[m+1][n+1];
            for (int i = 0; i <=m ; i++) {
                dp[i][0]=i;
            }
            for (int i = 0; i <=n ; i++) {
                dp[0][i]=i;
            }
            for (int i = 1; i <=m ; i++) {
                for (int j = 1; j <=n ; j++) {
                    if(str2.charAt(i-1)==str1.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                     dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                    }
                }
            }
            System.out.println(dp[m][n]);






        }


    }

}
