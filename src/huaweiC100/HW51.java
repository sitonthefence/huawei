package huaweiC100;

import java.util.Scanner;

public class HW51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            String[] split = in.next().split(",");
            int[] arr=new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int count=0;
            if(arr.length==1||arr.length==0){
                System.out.println(0);
                continue;
            }
            for (int i = 0; i < arr.length; i++) {
                if(i==0&&arr[i]>arr[i+1]){
                    count++;
                }
                if(i==arr.length-1&&arr[i]>arr[i-1]){
                    count++;
                }
                if(i!=arr.length-1&&i!=0&&arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                    count++;
                }


            }
            System.out.println(count);


        }


    }
}
