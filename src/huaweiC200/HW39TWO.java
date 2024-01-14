package huaweiC200;

import java.util.Scanner;

public class HW39TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int length = in.nextInt();
            int[] arr = new int[length];
            int sum=0;
            for (int i = 0; i < length; i++) {
                arr[i] = in.nextInt();
                sum+=arr[i];
            }
            int target=in.nextInt();
            int temp=length-target;
            int left=0;
            int right=temp-1;
            int minSum=Integer.MAX_VALUE;
            int currentSum=0;
            while (right<arr.length){
                if(left==0){
                    for (int i = left; i <=right ; i++) {
                        currentSum+=arr[i];
                    }

                }else {
                    currentSum=currentSum-arr[left-1]+arr[right];
                }

                    minSum=Math.min(currentSum,minSum);
                left++;
                right++;
            }
            System.out.println(sum-minSum);


        }


    }
}