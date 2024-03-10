package LC;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=nums.length-1;

            while (l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l+1<r&& nums[l]==nums[l+1] ) l++;
                    while (l<r-1&& nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else r--;

            }

        }
     return result;



    }

}
