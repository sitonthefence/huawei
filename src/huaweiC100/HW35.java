package huaweiC100;

import java.util.Scanner;

public class HW35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            while (in.hasNextLine()){
                String source = in.nextLine();
                String[] split = source.split(" ");
                int N = split.length;
                int H = Integer.valueOf(in.nextLine());
                if(N>H){
                    System.out.println(0);
                    continue;
                }

                int[] arr=new int[split.length];
                int max=Integer.MIN_VALUE;
                for (int i = 0; i < arr.length; i++) {
                    arr[i]=Integer.valueOf(split[i]);
                    max=Math.max(max,arr[i]);
                }
                int left=0;
                int right=max;
                int K=max;
                while (left<right){
                    int middle=(left+right)/2;
                    if(getTime(middle,arr)<=H){
                        K=middle;
                        right=middle;
                    }else {
                        left=middle+1;
                    }
                }
                System.out.println(K);

            }
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }
    public static int getTime(int speed,int[] nums){
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%speed==0){
                total=total+nums[i]/speed;
            }else {
                total=total+nums[i]/speed+1;
            }
        }
        return total;



    }
}
