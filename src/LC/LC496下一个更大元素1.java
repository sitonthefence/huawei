package LC;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496下一个更大元素1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <nums2.length ; i++) {
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result=new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i]= map.getOrDefault(nums1[i],-1);
        }
        return result;



    }



}
