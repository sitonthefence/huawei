package huaweiAB100;

import java.util.Arrays;
import java.util.Scanner;

public class HW18 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){

            int xiaoMing = in.nextInt();
            int length=in.nextInt();
            Integer[] arr=new Integer[length];
            for (int i = 0; i <arr.length ; i++) {
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr,
                    ((o1, o2) ->
                    {
                        if(Math.abs(o1-xiaoMing)!=Math.abs(o2-xiaoMing)){
                            return Math.abs(o1-xiaoMing)-Math.abs(o2-xiaoMing);
                        }else {
                            return o1-o2;
                        }
                    })

                    );
            for (Integer integer : arr) {
                System.out.print(integer+" ");
            }
        }



    }
}
