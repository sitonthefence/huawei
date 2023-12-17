package NK;

import java.util.Scanner;

public class HJ99 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int count=0;
            for (int i = 0; i <=length ; i++) {
                String s = String.valueOf(i);
                String s1 = String.valueOf(i * i);
                if(s1.endsWith(s)){
                    count++;
                }
            }
            System.out.println(count);





        }



    }



}
