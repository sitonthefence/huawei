package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    public static void backtracking(int[] nums,int begin){
        result.add(new LinkedList<>(path));
        if(begin>=nums.length){
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.offerLast(nums[i]);
            backtracking(nums,i+1);
            path.pollLast();
        }
    }
}
