package NK;

import java.util.Scanner;

public class HJ62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            String s = Integer.toBinaryString(source);
            int num=s.replace("0","").length();

            System.out.println(num);
        }


    }














}
