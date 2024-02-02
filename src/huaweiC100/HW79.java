package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW79 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int height = in.nextInt();
            int total = in.nextInt();
            Integer [] arr=new Integer[total];
            for (int i = 0; i < total; i++) {
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr,(o1,o2)->{
                if(Math.abs(o1-height)==Math.abs(o2-height)){
                    return o1-o2;
                }
                return Math.abs(o1-height)-Math.abs(o2-height);

                    }
                    );
            for (Integer integer : arr) {

                System.out.print(integer+" ");
            }
        }
    }

}
