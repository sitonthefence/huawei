package jikao;

import java.util.Scanner;

public class HW11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
        }
        int target = in.nextInt();
        int left=0;
        int right=0;
        int currentSum=0;
        int max=0;
        while (right<arr.length){
            if(arr[right]>target){
                right++;
                left=right;
                currentSum=0;
                continue;
            }
            currentSum+=arr[right];
            while (currentSum>target){
                currentSum=currentSum-arr[left];
                left++;
            }
            if(right-left+1>max){
                max=right-left+1;
            }
         right++;
        }
        System.out.println(max);

    }
}
