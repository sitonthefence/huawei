package huaweiAB100;

import java.util.Scanner;

public class HW9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            Integer source = in.nextInt();
            int count=0;
            for (int i = 1; i <=source; i++) {

                if(String.valueOf(i).matches("\\d*4\\d*")){
                    count++;
                }


            }
            System.out.println(source-count);






        }


    }


}
