package huaweiAB100;

import java.util.Arrays;
import java.util.Scanner;

public class HW20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i <arr.length ; i++) {
              arr[i]=in.nextInt();
            }
            int sum=0;
            for (int i = 0; i <arr.length ; i++) {
                sum=sum^arr[i];
            }
            if(sum!=0){
                System.out.println(-1);
            }else {
                Arrays.sort(arr);
                int result=0;
                for (int i = 1; i < arr.length ; i++) {
                    result=result+arr[i];
                }
                System.out.println(result);

            }


        }
    }
}
