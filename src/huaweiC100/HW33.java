package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW33 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while (in.hasNextInt()){
            int target = in.nextInt();
            int length = in.nextInt();
            Integer[] arr=new Integer[length];
            for (int i = 0; i < length; i++) {
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr,(o1, o2) ->{
                if(Math.abs(o1.intValue()-target)==Math.abs(o2.intValue()-target)){
                    return o1.intValue()-o2.intValue();
                }else {
                    return Math.abs(o1.intValue()-target)-Math.abs(o2.intValue()-target);
                }
            } );
            for (Integer integer : arr) {
                System.out.print(integer+" ");
            }



        }

    }
}
