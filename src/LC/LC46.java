package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path =new LinkedList<>();

    public static void main(String[] args) {
        int[] nums={1,2,3};
        permute(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }

    public  static  void  backtracking(int[] nums,boolean[] used){

        if(path.size()==nums.length){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i]=true;
            path.offerLast(nums[i]);
            backtracking(nums,used);
            path.pollLast();
            used[i]=false;
        }
    }
}
