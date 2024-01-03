package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int[] arr=new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int target=in.nextInt();
            int index = Arrays.binarySearch(arr, target);
            System.out.println(-index );


        }
    }
}
