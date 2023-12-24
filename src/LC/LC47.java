package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC47 {
    //去重必须排序

    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path =new LinkedList<>();

    public static void main(String[] args) {
        int[] nums={3,3,0,3};
        permuteUnique(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }

    public static void  backtracking(int[] nums,boolean[] used){
       if(path.size()==nums.length){
           result.add(new LinkedList<>(path));
           return;
       }
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            if(!used[i]){
                path.offerLast(nums[i]);
                used[i]=true;
                backtracking(nums,used);
                path.pollLast();
                used[i]=false;
            }
        }
    }

}
