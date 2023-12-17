package NK;

import java.math.BigInteger;
import java.util.Scanner;

public class H57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        BigInteger bigInteger1 = new BigInteger(s1, 10);
        BigInteger bigInteger2 = new BigInteger(s2, 10);
        BigInteger bigInteger3 = bigInteger1.add(bigInteger2);
        System.out.println(bigInteger3);


    }


}
