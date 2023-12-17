package NK;

import java.util.Scanner;

public class HJ40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            int length1 = source.length()-source.replaceAll("[a-zA-Z]+", "").length();
            int length2 = source.length()-source.replaceAll("\\s+", "").length();
            int length3 = source.length()-source.replaceAll("[0-9]+", "").length();
            int length4 = source.length()-length1-length2-length3;
            System.out.println(length1);
            System.out.println(length2);
            System.out.println(length3);
            System.out.println(length4);


        }


    }
}
