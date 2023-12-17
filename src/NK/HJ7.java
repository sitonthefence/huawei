package NK;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextFloat()){
            float v1 = in.nextFloat();
            int v2= (int) v1;
            float v3 = v2 - v1;
            if(v3<0.5){
                System.out.println(Math.round(v1));
            }else {
                System.out.println(Math.floor(v1));

            }


        }



    }





}
