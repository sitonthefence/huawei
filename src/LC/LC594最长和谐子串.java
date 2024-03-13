package LC;

import java.util.Arrays;

public class LC594最长和谐子串 {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 1, 1,1}));
    }


    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=0;
        int max=0;
        while (right<nums.length){

            while (nums[right]-nums[left]>1){

                left++;
            }
            if(nums[right]-nums[left]==1){
                max=Math.max(right-left+1,max);
            }

            right++;



        }
        return max;


    }
}
