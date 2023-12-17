package NK;

import java.util.Arrays;
import java.util.Scanner;

public class HJ13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            for (int i = split.length-1; i >=0; i--) {
                System.out.print(split[i]+" ");

            }


        }


    }


}
