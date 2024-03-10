package LC;

public class LC1004 {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int max=0;
        int currentK=0;
        while (right<nums.length){
            if(nums[right]==0){
                currentK++;
            }
            while (currentK>k){
                if(nums[left]==0){
                    currentK--;
                }
                left++;
            }
            max=Math.max(right-left+1,max);
           right++;
    }
        return max;
}
}
