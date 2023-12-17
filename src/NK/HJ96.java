package NK;

import java.util.Scanner;

public class HJ96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            System.out.println(s.replaceAll("([0-9]+)", "*$1*"));


        }
    }


}
