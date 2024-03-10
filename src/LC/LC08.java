package LC;

import java.util.HashSet;
import java.util.LinkedList;

public class LC08 {
   static HashSet<String> result=new HashSet<>();
   static LinkedList<Character> path=new LinkedList<>();
   static boolean[] used;


    public String[] permutation(String S) {
        used=new boolean[S.length()];

        dfs(0,S);
        return result.toArray(new String[0]);

    }
    public static void dfs(int index,String S){
        if(path.size()==S.length()){
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                stringBuilder.append(path.get(i));
            }
            result.add(stringBuilder.toString());
        }
        for (int i = 0; i < S.length(); i++) {
            if(used[i]) continue;
            used[i]=true;
           path.add(S.charAt(i));
           dfs(index+1,S);
           path.pollLast();
           used[i]=false;

        }

    }


}
