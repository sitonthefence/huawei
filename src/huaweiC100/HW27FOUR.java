package huaweiC100;

import java.util.Scanner;

public class HW27FOUR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] g=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j]=in.nextInt();
            }
        }
        if(g[0][0]==1||g[m-1][n-1]==1){
            System.out.println(0);
            return;
        }
        long[][] dp=new long[m][n];
        dp[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(g[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i!=0){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j!=0){
                    dp[i][j]+=dp[i][j-1];
                }

            }
        }
        System.out.println(dp[m-1][n-1]);
        
        
        
    }
  
}
