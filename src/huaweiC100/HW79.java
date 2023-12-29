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
                if(Math.abs(o1.intValue()-height)==Math.abs(o2.intValue()-height)){
                    return o1.intValue()-o2.intValue();
                }
                return Math.abs(o1.intValue()-height)-Math.abs(o2.intValue()-height);

                    }
                    );
            for (Integer integer : arr) {

                System.out.print(integer+" ");
            }
        }
    }

}
