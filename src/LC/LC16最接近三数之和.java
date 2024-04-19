package LC;

import java.util.Arrays;

public class LC16最接近三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);

        // 初始化最接近的和
        int closestSum = nums[0] + nums[1] + nums[2];

        // 遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // 使用双指针法查找最接近的和
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 如果当前和更接近目标值，则更新最接近的和
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // 调整指针位置
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // 如果和等于目标值，直接返回目标值
                    return target;
                }
            }
        }

        return closestSum;
    }
}
