package LC;

import java.util.HashSet;

public class LC128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        // 如果数组为空，直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 使用 HashSet 存储数组中的所有数字，以便快速查找
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 遍历数组中的每个数字
        for (int num : numSet) {
            // 如果当前数字是连续序列的起点（即没有前一个数字）
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 继续查找连续序列中的下一个数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最长连续序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
