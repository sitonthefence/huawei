package LC;

import java.util.HashSet;
import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dic=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i ; j++) {
                   if(dp[j]&&dic.contains(s.substring(j,i))){
                       dp[i]=true;
                   }
            }

        }
        return dp[s.length()];
        
        
    }

}
