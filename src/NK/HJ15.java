package NK;

import java.util.Scanner;

public class HJ15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int i = in.nextInt();
            String s = Integer.toBinaryString(i);
            int num=0;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='1'){
                    num++;

                }

            }
            System.out.println(num);


        }


    }



}
