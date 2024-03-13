package NK;

import java.util.Scanner;

public class HJ65查找两个字符串ab中的最长公共子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        if(a.length()>b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        int[][] dp=new int[a.length()+1][b.length()+1];
        int max=0;
        int m=0;
        int n=0;

        for (int i = 1; i < a.length()+1; i++) {
            for (int j = 1; j < b.length()+1; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                     if(dp[i][j]>max){
                         max=dp[i][j];
                        m=i-dp[i][j];
                        n=i;

                     }
                }
            }
        }
        System.out.println(a.substring(m, n));


    }
}
