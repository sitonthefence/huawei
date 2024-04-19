package LC;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LC503下一个更大元素2 {
    public static void main(String[] args) {
        int[] nums={1,0,0};
        int[] ints = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] result =new int[nums.length];
        Arrays.fill(result,-1);
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < 2*nums.length-1; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<nums[i%nums.length]){
                result[queue.pollLast()]=nums[i%nums.length];
            }

            queue.offerLast(i%nums.length);

        }
        return  result;


    }
}
