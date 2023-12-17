package NK;

import java.util.Scanner;

public class HJ53 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int source = in.nextInt();
            if (source == 1 || source == 2) {
                System.out.println(-1);
            } else if (
                    source % 4 == 0
            ) {
                System.out.println(3);
            } else if (source % 4 == 1
            ) {
                System.out.println(2);
            } else if (source % 4 == 2) {
                System.out.println(4);
            } else if (source % 4 == 3) {
                System.out.println(2);


            }
        }


    }

}
