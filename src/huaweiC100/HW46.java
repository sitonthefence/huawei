package huaweiC100;

import java.util.Scanner;

public class HW46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length=in.nextInt();
            int arr[]=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            int money=in.nextInt();
             int left=0;
             int right=0;
             int maxSum=0;
             int currentSum=0;
             while (right<arr.length){
                 currentSum=currentSum+arr[right];
                 while (currentSum>money){
                     currentSum=currentSum-arr[left];
                    left++;
                 }
                 maxSum=Math.max(maxSum,right-left+1);
                right++;
             }
            System.out.println(maxSum);

        }
    }
}
