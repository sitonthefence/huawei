package huaweiC100;

import java.util.Scanner;

public class HW59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String target = source.replace("/,/", "/").
                    replace(",/", "/").
                    replace("/,", "/").
                    replace(",", "/");
            System.out.println(target);


        }
    }
}
