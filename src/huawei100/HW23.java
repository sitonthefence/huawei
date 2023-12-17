package huawei100;

import java.util.Scanner;

public class HW23 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int target = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < length; i++) {
                arr[i]=in.nextInt();
            }
             int count=0;
            for (int i = 0; i <=arr.length-1 ; i++) {
                int sum=arr[i];
                if(sum>=target){
                    count++;
                }
                for (int j = i+1; j < arr.length; j++) {
                    sum=sum+arr[j];
                    if(sum>=target){
                        count++;
                    }

                }
            }
            System.out.println(count);



        }


    }
}
