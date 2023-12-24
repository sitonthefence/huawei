package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC39 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        combinationSum(candidates, target);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,0,target,0);
        return result;
    }
    public static void backtracking(int[] candidates,int begin,int target,int sum ){
          if(sum>target){
              return;
          }
          if(sum==target){
              result.add(new LinkedList<>(path));
              return;
          }
        for (int i = begin; i <candidates.length ; i++) {
        sum+=candidates[i];
        path.offerLast(candidates[i]);
            backtracking(candidates,i,target,sum);
            sum-=candidates[i];
            path.pollLast();
        }
    }
}
