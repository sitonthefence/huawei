package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {
    static LinkedList<Integer> path=new LinkedList<>();
    static List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        combinationSum3(3,9);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n,k,0,1);
        return result;
    }
    public static void backtracking (int target,int k,int sum,int begin){
      if(sum>target){
          return;
      }
      if(path.size()==k){
          if(sum==target){
              result.add(new ArrayList<>(path));
          }
          return;
      }
        for (int i = begin; i <=9-(k-path.size())+1 ; i++) {
            sum=sum+i;
            path.offerLast(i);
            backtracking(target,k,sum,i+1);
            sum=sum-i;
            path.pollLast();

        }




    }







}
