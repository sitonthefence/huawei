package huaweiAB100;

import java.util.Scanner;

public class HW90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int target = in.nextInt();
            int flag=-1;
            outerLook:
            for (int i = 0; i < split.length-1; i++) {
                for (int j = i+1; j <split.length ; j++) {
                    if(split[i].equals(split[j])&&
                            Math.abs(i-j)<=target){

                        flag=i;
                        break outerLook;
                    }


                }

            }

            System.out.println(flag);


        }


    }


}
