package NK;

import java.util.Scanner;

public class HJ31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split("[^a-zA-Z]+");
            for (int i = split.length-1; i >=0 ; i--) {
                System.out.print(split[i]+" ");

            }


        }


    }
}
