package LC;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LC228汇总区间 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }
    public static List<String> summaryRanges(int[] nums) {

        List<String> result=new ArrayList<>();
        if(nums.length==0) return result;
        if(nums.length==1) {
            result.add(nums[0]+"");
            return result;
        }
        int left=0;
        int right = 1;
        for (; right <nums.length ; right++) {
            if((long)nums[right]-(long) nums[right-1]>1){
               result.add(getAnswer(nums,left,right-1));
                left=right;
            }
        }
        if(nums[right-1]-nums[right-2]==1){
            result.add(getAnswer(nums,left,right-1));
        }else {
            result.add(nums[right-1]+"");
        }
        return result;
    }
    public static String getAnswer(int[]nums,int left,int right){
        if(right-left==0){
            return String.valueOf(nums[right]);
        }else {
            return nums[left]+"->"+nums[right];
        }
    }
}
