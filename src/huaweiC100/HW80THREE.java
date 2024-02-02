package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW80THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] nums=new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(split[i]);
        }
        int jump = in.nextInt();
        int left=in.nextInt();
        int sum = sumOfLeft(nums, jump, left);
        System.out.println(sum);

    }
    public static int sumOfLeft(int[]nums,int jump,int left){
       /* if(left==0){
            return 0;
        }*/
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int index=1;
        while (list.size()>left){
            index=(index+jump)%list.size();
            list.remove(index);
        }
        int sum=0;
        for (int i = 0; i <list.size() ; i++) {
            sum+=list.get(i);

        }
        return sum;
    }
}
