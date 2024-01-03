package huaweiC100;

import java.util.Scanner;

public class HW60 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int length = in.nextInt();
            int target = in.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    if(getSum(arr,i,j)>=target){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int getSum(int[] arr ,int left,int right){
        int sum=0;
        for (int i = left; i <=right ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
