package LC;

public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
       int left=0;
       int right=0;
       int max=1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>nums[right]){
                max=Math.max(i-left+1,max);
            }else {
                left=i;
            }
            right++;
        }
        return max;



    }
}
