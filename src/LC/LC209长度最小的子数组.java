package LC;

public class LC209长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        minSubArrayLen(7,nums);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int curSum=0;
        int leastLength=Integer.MAX_VALUE;
     while (right<nums.length){
         curSum=curSum+nums[right];
         while(curSum>=target){
             leastLength=Math.min(leastLength,right-left+1);
             curSum=curSum-nums[left];
             left++;
         }
         right++;

     }
     if(leastLength==Integer.MAX_VALUE){
         return 0;
     }
     return  leastLength;

    }
}
