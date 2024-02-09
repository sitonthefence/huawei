package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;


public class HW26THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        in.nextLine();
        String[] split = in.nextLine().split(" ");
        if (split.length == 1) {
            System.out.println(Integer.valueOf(split[0]));
            return;
        }
        long[] arr = new long[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(split[i]);
        }
        Arrays.sort(arr);
        long left = arr[arr.length - 1];
        long right = arr[arr.length - 1] + arr[arr.length - 2];
        long target = right;
        while (left<right){
            long mid=(left+right)/2;
            if(getMonth(mid,arr)<=time){
                right=mid;
                target=mid;

            }else {
                left=mid+1;
            }



        }
        System.out.println(target);



    }
    public static int getMonth(long mid, long[] arr){
        int count=0;
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            if(arr[left]+arr[right]<=mid){
                left++;
            }
            right--;
            count++;
        }
        return count;




    }
}
