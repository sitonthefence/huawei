package huaweiC100;

import java.util.Scanner;

public class HW9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            int[] result=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i]<arr[j]){
                        result[i]=j;
                        break;

                    }

                }
            }

            for (int i : result) {
                System.out.print(i+" ");
            }


        }
    }
}
