package LC;

import java.util.Arrays;

public class LC132分割回文串2 {
    public static void main(String[] args) {
        System.out.println(mincut("ab"));
    }
    public static int mincut( String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len - 1);
        for (int i = 0; i < len; i++) {
            mincutHelper(s, i, i, dp);
            mincutHelper(s, i, i + 1, dp);
        }
        return dp[len - 1];
    }

    public static void mincutHelper(String s, int i, int j,int[] dp){
        int len = s.length( );
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
            dp[j] = Math.min(dp[j],(i==0?-1:dp[i-1])+1);
            i--;
            j++;
        }
    }
}
