package huaweiAB100;

import java.util.Scanner;

public class HW23TWO {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int target = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < length; i++) {
                arr[i]=in.nextInt();
            }
            int left=0;
            int right=0;
            int currentSum=0;
            int count=0;
            while (right<arr.length){
                currentSum=currentSum+arr[right];
                while (currentSum>=target){
                    count=count+arr.length-right;
                    currentSum=currentSum-arr[left];
                    left++;
                }
                right++;
            }
            System.out.println(count);









        }


    }
}
