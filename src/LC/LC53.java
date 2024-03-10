package LC;

public class LC53 {
    public int maxSubArray(int[] nums) {
     int pre=0;
     int res=nums[0];
        for (int num : nums) {
            pre=Math.max(num,pre+num);
            res=Math.max(pre,res);

        }
        return res;
    }
}
