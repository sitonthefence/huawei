package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40组合总和2 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path =new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;

        combinationSum2(candidates,target);
        System.out.println(result);

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
       if(candidates==null||candidates.length==0){
           return result;
       }
        boolean[] used=new boolean[candidates.length];
        Arrays.sort(candidates);
       backtracking(candidates,0,target,0,used);
       return  result;
    }
    public  static  void backtracking (int[] candidates,int begin,int target,int sum,boolean[] used){
        if(sum>target){
            return;
        }
        if(sum==target){
            result.add(new LinkedList<>(path));
           return;
        }
        for (int i = begin; i <candidates.length ; i++) {
           if(i>0&&candidates[i]==candidates[i-1]&&!used[i-1]){
             continue;
           }
           used[i]=true;
            path.offerLast(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,i+1,target,sum,used);
            path.pollLast();
            sum-=candidates[i];
            used[i]=false;
        }
    }

}
