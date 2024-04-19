package LC;

import java.util.HashSet;
import java.util.Set;

public class LC1695删除子数组的最大得分 {
    public int maximumUniqueSubarray(int[] nums) {
    int left = 0,right =0;
    int sum = 0;
    int max = 0;
    Set<Integer> windows = new HashSet<>();
    while(right < nums.length){
        sum += nums[right];
        //收缩窗口
        while(windows.contains(nums[right])){
            sum -= nums[left];
            //使用Integer，否则会按照index索引删除
            windows.remove(Integer.valueOf(nums[left]));
            left++;
        }

        windows.add(nums[right]);
        right++;
        //记录比较得到最大得分
        max = Math.max(max,sum);
    }
    return max;
}

}
