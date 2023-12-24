package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC90 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        int[] nums={1,2,2};
      subsetsWithDup(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtracking( nums,0,used);
     return result;
    }
    public static void backtracking(int[] nums,int begin,boolean[] used){
        result.add(new LinkedList<>(path));
        if(begin==nums.length){
            return;
        }
        for (int i = begin; i <nums.length ; i++) {
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.offerLast(nums[i]);
        used[i]=true;
            backtracking(nums,i+1,used);
            path.pollLast();
            used[i]=false;
        }

    }


}
