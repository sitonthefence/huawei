package huawei100;

import java.util.Scanner;

public class HW21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            String source = in.next();
            String replace = source.
                    replace("/,/", "/").replace(",/", "/").
                    replace("/.", "/").
                    replace(",", "/");

            System.out.println(replace);


        }
    }



}
