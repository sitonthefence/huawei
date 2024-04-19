package LC;

import java.util.Arrays;

public class LC179最大数 {
    public String largestNumber(int[] nums) {
      String[] newNums=new String[nums.length];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(newNums,(a,b)->
                        (b+a).compareTo(a+b)
                );
        if(newNums[0].equals("0")) return "0";
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < newNums.length; i++) {
            stringBuilder.append(newNums[i]);
        }
         return  stringBuilder.toString();



    }
}
