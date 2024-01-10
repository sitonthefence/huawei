package NK;


import java.util.*;

public class Main {
    public static int check(int k, List<Integer> nums) {
        int left = 0, right = nums.size() - 1, ans = 0;
        while (left <= right) {
            if (nums.get(left) + nums.get(right) > k) {
                right--;
            } else {
                left++;
                right--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        Collections.sort(nums);

        int left = Collections.max(nums);
        int right = nums.stream().mapToInt(Integer::intValue).sum() + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}




