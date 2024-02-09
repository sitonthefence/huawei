package huaweiC100;

import java.util.Scanner;

public class HW60THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length=in.nextInt();
       int target=in.nextInt();
       int arr[]=new int[length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=in.nextInt();
        }
        int[] preSum=new int[length+1];
        for (int i = 1; i <preSum.length ; i++) {
            preSum[i]=arr[i-1]+preSum[i-1];
        }
        long count=0;
       int left=0;
       int right=1;
       while (right<preSum.length){
           if(preSum[right]-preSum[left]>=target){
               count+=preSum.length-right;
               left++;
               right=left+1;
           }else {
               right++;
           }


       }


        System.out.println(count);
    }





}
