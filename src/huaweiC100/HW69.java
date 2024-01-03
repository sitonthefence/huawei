package huaweiC100;

import java.util.Scanner;

public class HW69 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            int count=0;
            for (int i = 0; i < arr.length-2; i++) {
                for (int j = i+1; j < arr.length-1; j++) {
                    for (int k = j+1; k < arr.length; k++) {
                        if(arr[i]<arr[j]&&arr[j]<arr[k]||
                        arr[i]>arr[j]&&arr[j]>arr[k]){
                            count++;
                        }

                    }
                }
            }

            System.out.println(count);
        }

    }
}
