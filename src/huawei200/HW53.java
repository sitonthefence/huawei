package huawei200;

import java.util.*;

public class HW53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int target = in.nextInt();
            String source = in.next();
            List<LinkedList<Integer>> result = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            String[] split = source.substring(1, source.length() - 1).split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.valueOf(split[i]);
            }
            backtracking(target, nums, 0, 0,  result, path);
            System.out.println(result.get(0));
        }
    }

    public static void backtracking(int target, int[] nums, int begin, int sum,
                                    List<LinkedList<Integer>> result,
                                    LinkedList<Integer> path) {
        if (sum == target&&path.size()==3) {
         result.add(new LinkedList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.offerLast(nums[i]);
            sum += nums[i];
            backtracking(target, nums, i + 1,  sum, result, path);
            sum -= nums[i];
            path.pollLast();
        }
    }
}
